package com.nostra.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.nostra.service.TarikSetorTunaiService;

import com.nostra.vo.ResultVO;
import com.nostra.vo.TarikSetorTunaiVO;





@RestController
@RequestMapping("/api/tarik-setor-tunai")
public class TarikSetorTunaiController {

    @Autowired
    TarikSetorTunaiService tarikSetorTunaiService;
    
    @RequestMapping(value = "/transaksi",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ResultVO> add(@RequestBody TarikSetorTunaiVO addVO) {
        AbstractRequestHandler handler = new AbstractRequestHandler() {
            @Override
            public Object processRequest() {
                return tarikSetorTunaiService.tarikSetorTunai(addVO);
            }
        };
        return handler.getResult();
    }

 
    
}
