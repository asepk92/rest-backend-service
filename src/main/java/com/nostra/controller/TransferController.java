package com.nostra.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.nostra.service.TransferService;

import com.nostra.vo.ResultVO;

import com.nostra.vo.TransferVO;





@RestController
@RequestMapping("/api/transfer")
public class TransferController {

    @Autowired
    TransferService transferService;
    
    @RequestMapping(value = "/transfer",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ResultVO> add(@RequestBody TransferVO addVO) {
        AbstractRequestHandler handler = new AbstractRequestHandler() {
            @Override
            public Object processRequest() {
                return transferService.transfer(addVO);
            }
        };
        return handler.getResult();
    }

 
    
}
