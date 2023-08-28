package com.rnerd.code.controllers;

import com.rnerd.code.payload.request.CustomerReq;
import com.rnerd.code.payload.response.ResponseMsg;
import com.rnerd.code.services.ServiceCenterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/sc")
@RequiredArgsConstructor
public class ServiceCenterController {

    private final ServiceCenterService serviceCenterService;

    @PostMapping("/customer")
    public ResponseEntity<Map<String, String>> CustomerDetailController(@Valid @RequestBody CustomerReq customerReq) throws Exception{
        Map<String, String> res;
        try {
            serviceCenterService.AddCustomer(customerReq);
            res = ResponseMsg.Msg("Details Added Successfully");
        }catch (Exception e){
            throw e;
        }

        return ResponseEntity.ok().body(res);
    }

//    @GetMapping("/AvailableParts")
//    public ResponseEntity<Map<String, String>> AvailablePartsController(){
//
//    }
}
