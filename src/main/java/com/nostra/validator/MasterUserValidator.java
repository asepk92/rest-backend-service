package com.nostra.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.nostra.vo.MasterUserVO;

@Component
public class MasterUserValidator {

	public String validateMasterUser(MasterUserVO masterUserVO) {


        if (StringUtils.isEmpty(masterUserVO.getEmail())) {
            return "email is required";
        }
        
        if (StringUtils.isEmpty(masterUserVO.getUsername())) {
            return "username is required";
        }
        
        if (StringUtils.isEmpty(masterUserVO.getPassword())) {
            return "password is required";
        }
        
       


        return null;
    }
	
	
	public String validateLogin(MasterUserVO masterUserVO) {
        
        if (StringUtils.isEmpty(masterUserVO.getUsername())) {
            return "username is required";
        }
        
        if (StringUtils.isEmpty(masterUserVO.getPassword())) {
            return "password is required";
        }
        
       


        return null;
    }
}
