package com.rnerd.code.controllers;

import com.rnerd.code.payload.request.CustomerReq;
import com.rnerd.code.payload.response.ResponseMsg;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/sc")
public class ServiceTeamController {


    @PostMapping("/customer")
    public ResponseEntity<Map<String, String>> CustomerDetailController(@Valid @RequestBody CustomerReq customerReq){
        Map<String, String> res = ResponseMsg.Msg("Details Added Successfully");
        return ResponseEntity.ok().body(res);
    }
}
