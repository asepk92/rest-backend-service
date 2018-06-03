package com.nostra.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.nostra.vo.HistoriTransaksiVO;
import com.nostra.vo.MasterUserVO;

@Component
public class HistoriTransaksiValidator {

	public String validateHistoriTransaksi(HistoriTransaksiVO historiTransaksiVO) {

        if (StringUtils.isEmpty(historiTransaksiVO.getUserFrom())) {
            return "user from is required";
        }


        if (StringUtils.isEmpty(historiTransaksiVO.getNoRekening())) {
            return "no rekening is required";
        }

        return null;
    }
	
	
	
}
