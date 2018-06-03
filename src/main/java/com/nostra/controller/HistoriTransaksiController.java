package com.nostra.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nostra.service.HistoriTransaksiService;

import com.nostra.vo.HistoriTransaksiVO;
import com.nostra.vo.ResultPageVO;
import com.nostra.vo.ResultVO;



import java.util.Map;



@RestController
@RequestMapping("/api/histori-transaksi")
public class HistoriTransaksiController {

    @Autowired
    HistoriTransaksiService historiTransaksiService;
    
    @RequestMapping(value = "/add",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ResultVO> add(@RequestBody HistoriTransaksiVO addVO) {
        AbstractRequestHandler handler = new AbstractRequestHandler() {
            @Override
            public Object processRequest() {
                return historiTransaksiService.addHistoriTransaksi(addVO);
            }
        };
        return handler.getResult();
    }

    @RequestMapping(value = "/list-of-histori-transaksi-with-pagination",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ResultPageVO> page(@RequestParam(value = "userFrom", defaultValue = "") String userFrom,
    										 @RequestParam(value = "noRekening", defaultValue = "") String noRekening,	
                                             @RequestParam(value = "page", defaultValue = "0") Integer page,
                                             @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                             @RequestParam(value = "sortBy", required = false) String sortBy,
                                             @RequestParam(value = "direction", required = false) String direction
    ) {
        Map<String, Object> pageMap = historiTransaksiService.search(userFrom, noRekening, page, limit, sortBy, direction);
        return AbstractRequestHandler.constructListResult(pageMap);
    }
    
   
    
}
