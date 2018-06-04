package com.nostra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.nostra.converter.HistoriTransaksiVOConverter;
import com.nostra.domain.HistoriTransaksi;
import com.nostra.exception.NostraException;
import com.nostra.repository.HistoriTransaksiRepository;
import com.nostra.util.EncryptService;
import com.nostra.validator.HistoriTransaksiValidator;
import com.nostra.vo.HistoriTransaksiTempVO;
import com.nostra.vo.HistoriTransaksiVO;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

@Slf4j
@Service
public class HistoriTransaksiService {

	@Autowired
	HistoriTransaksiRepository historiTransaksiRepository;

	@Autowired
	HistoriTransaksiVOConverter historiTransaksiVOConverter;
	
	@Autowired
	HistoriTransaksiValidator historiTransaksiValidator;

	@Transactional //TODO Transactional harus dipasang untuk setiap API yang melakukan add/update ke database
    public Boolean addHistoriTransaksi(HistoriTransaksiVO vo) {


        //TODO validasi harus selalu dilakukan untuk memastikan tidak ada data kotor yang masuk ke dalam database
        String message = historiTransaksiValidator.validateHistoriTransaksi(vo);
        if (message != null) throw new NostraException(message);


        HistoriTransaksi ht = historiTransaksiVOConverter.transferVOToModel(vo, null);
        HistoriTransaksi added = historiTransaksiRepository.save(ht);
        if (null == added) throw new NostraException("Histori Transaksi cannot be added");

        return Boolean.TRUE;
    }
	
	public Map<String, Object> search(String userFrom, String noRekening, Integer page, Integer limit, String sortBy,
			String direction) {

		Page<HistoriTransaksi> resultPage = null;
		List<HistoriTransaksi> models;
		Collection<HistoriTransaksiVO> vos;

		sortBy = StringUtils.isEmpty(sortBy) ? "userFrom" : sortBy;
		direction = StringUtils.isEmpty(direction) ? "desc" : direction;
		
		Pageable pageable = PageRequest.of(page, limit, AbstractBaseService.getSortBy(sortBy, direction));

		if (!StringUtils.isEmpty(userFrom) && StringUtils.isEmpty(noRekening)) {
			resultPage = historiTransaksiRepository.findByUserFrom(userFrom, pageable);
		} else if (StringUtils.isEmpty(userFrom) && !StringUtils.isEmpty(noRekening)) {
			resultPage = historiTransaksiRepository.findByNoRekening(noRekening, pageable);
		} else if (!StringUtils.isEmpty(userFrom) && !StringUtils.isEmpty(noRekening)) {
			resultPage = historiTransaksiRepository.findByUserFromAndNoRekening(userFrom, noRekening, pageable);
		}else {
			resultPage = historiTransaksiRepository.findAll(pageable);
		}

		models = resultPage.getContent();
		vos = historiTransaksiVOConverter.transferListOfModelToListOfVO(models, new ArrayList<>());
		return AbstractBaseService.constructMapReturn(vos, resultPage.getTotalElements(), resultPage.getTotalPages());

	}
	
	public Map<String, Object> searchNative(String nama, String noRekening, Integer page, Integer limit, String sortBy,
			String direction) {

		String[] temp = null;
		Collection<HistoriTransaksiTempVO> vos = new ArrayList<>();

		if (!StringUtils.isEmpty(nama) || !StringUtils.isEmpty(noRekening)) {
			temp = historiTransaksiRepository.findByUserFromAndNoRekeningNative(nama, noRekening);
		} else {
			temp = historiTransaksiRepository.findAllNative();
		}
		
		for (int i = 0; i < temp.length; i++) {
            log.info("temp [] " + temp[i]);
            String[] split = temp[i].split(",");
            HistoriTransaksiTempVO historiTransaksiVO = new HistoriTransaksiTempVO();
            historiTransaksiVO.setKdTransaksi(split[0]);
            historiTransaksiVO.setUserFrom(split[1]);
            historiTransaksiVO.setNamaLengkap(split[2]);
            historiTransaksiVO.setNoRekening(split[3]);
            historiTransaksiVO.setJenisTransaksi(split[4]);
            historiTransaksiVO.setAmount(split[5]);
            historiTransaksiVO.setKdBank(split[6]);
            historiTransaksiVO.setNamaBank(split[7]);
            historiTransaksiVO.setNoRekeningTujuan(split[8]);
            historiTransaksiVO.setUserTo(split[9]);
            historiTransaksiVO.setNamaTo(split[10]);
            historiTransaksiVO.setKeterangan(split[11]);
            historiTransaksiVO.setCreatedDate(split[12]);
            vos.add(historiTransaksiVO);
		}
		
		int totalPage = temp.length / limit;
        return AbstractBaseService.constructMapReturn(vos, temp.length, totalPage);

	}
	
	
	

}
