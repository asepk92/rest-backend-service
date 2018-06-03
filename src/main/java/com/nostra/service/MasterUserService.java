package com.nostra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.nostra.converter.MasterUserVOConverter;
import com.nostra.domain.MasterUser;
import com.nostra.exception.NostraException;
import com.nostra.repository.MasterUserRepository;
import com.nostra.util.EncryptService;
import com.nostra.validator.MasterUserValidator;
import com.nostra.vo.MasterUserVO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

@Service
public class MasterUserService {

	@Autowired
	MasterUserRepository masterUserRepository;

	@Autowired
	MasterUserVOConverter masterUserVOConverter;
	
	@Autowired
	MasterUserValidator masterUserValidator;

	@Transactional //TODO Transactional harus dipasang untuk setiap API yang melakukan add/update ke database
    public Boolean addMasterUser(MasterUserVO vo) {


        //TODO validasi harus selalu dilakukan untuk memastikan tidak ada data kotor yang masuk ke dalam database
        String message = masterUserValidator.validateMasterUser(vo);
        if (message != null) throw new NostraException(message);


        MasterUser masterUser = masterUserVOConverter.transferVOToModel(vo, null);
        masterUser.setPassword(EncryptService.newInstance().encode(vo.getPassword()));
        MasterUser added = masterUserRepository.save(masterUser);
        if (null == added) throw new NostraException("Master User cannot be added");

        return Boolean.TRUE;
    }
	
	public Map<String, Object> search(String email, Integer page, Integer limit, String sortBy,
			String direction) {

		Page<MasterUser> resultPage = null;
		List<MasterUser> models;
		Collection<MasterUserVO> vos;

		sortBy = StringUtils.isEmpty(sortBy) ? "email" : sortBy;
		direction = StringUtils.isEmpty(direction) ? "desc" : direction;
		
		Pageable pageable = PageRequest.of(page, limit, AbstractBaseService.getSortBy(sortBy, direction));

		if (!StringUtils.isEmpty(email)) {
			resultPage = masterUserRepository.findByEmail(email, pageable);
		} else {
			resultPage = masterUserRepository.findAll(pageable);
		}

		models = resultPage.getContent();
		vos = masterUserVOConverter.transferListOfModelToListOfVO(models, new ArrayList<>());
		return AbstractBaseService.constructMapReturn(vos, resultPage.getTotalElements(), resultPage.getTotalPages());

	}
	
	public MasterUserVO login(String username, String password){
		
		MasterUserVO vo = new MasterUserVO();
		MasterUser masterUser = null;
		
		
		if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
			masterUser = masterUserRepository.findByUsernameAndPassword(username, EncryptService.newInstance().encode(password));
		} 
					
		masterUserVOConverter.transferModelToVO(masterUser, vo);
		
		return vo;
		
	}
	

}
