package com.nostra.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nostra.service.MasterUserService;
import com.nostra.vo.MasterUserVO;
import com.nostra.vo.ResultPageVO;
import com.nostra.vo.ResultVO;



import java.util.Map;



@RestController
@RequestMapping("/api/master-user")
public class MasterUserController {

    @Autowired
    MasterUserService masterUserService;
    
    @RequestMapping(value = "/registrasi",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ResultVO> add(@RequestBody MasterUserVO addVO) {
        AbstractRequestHandler handler = new AbstractRequestHandler() {
            @Override
            public Object processRequest() {
                return masterUserService.addMasterUser(addVO);
            }
        };
        return handler.getResult();
    }

    @RequestMapping(value = "/list-of-master-user-with-pagination",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ResultPageVO> page(@RequestParam(value = "email", defaultValue = "") String email,	
                                             @RequestParam(value = "page", defaultValue = "0") Integer page,
                                             @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                             @RequestParam(value = "sortBy", required = false) String sortBy,
                                             @RequestParam(value = "direction", required = false) String direction
    ) {
        Map<String, Object> pageMap = masterUserService.search(email, page, limit, sortBy, direction);
        return AbstractRequestHandler.constructListResult(pageMap);
    }
    
    @RequestMapping(value = "/login",
          method = RequestMethod.GET,
          produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ResultVO> page(@RequestParam(value = "username", defaultValue = "") String username,
  										   @RequestParam(value = "password", defaultValue = "") String password	
                                          
    ) {
    	AbstractRequestHandler handler = new AbstractRequestHandler() {
            @Override
            public Object processRequest() {
                return masterUserService.login(username, password);
            }
        };
        return handler.getResult();
    }
    
}
