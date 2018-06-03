package com.nostra.controller;


import com.nostra.exception.NostraException;
import com.nostra.util.RestUtil;
import com.nostra.vo.ResultPageVO;
import org.springframework.http.ResponseEntity;

/**
 * agus w
 */
public abstract class AbstractRequestPageHandler {

    public ResponseEntity<ResultPageVO> getResult() {
        ResultPageVO result = new ResultPageVO();
        try {
            return processRequest();
        } catch (NostraException e) {
            result.setMessage(e.getCode().name());
            result.setResult(e.getMessage());
        }
        return RestUtil.getJsonResponse(result);
    }

    public abstract ResponseEntity<ResultPageVO> processRequest();
}
