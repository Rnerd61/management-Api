package com.rnerd.code.controllers;

import com.rnerd.code.models.ServiceTeam.AvailableParts;
import com.rnerd.code.payload.request.CustomerReq;
import com.rnerd.code.payload.response.ResponseMsg;
import com.rnerd.code.services.ServiceCenterService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/sc")
@RequiredArgsConstructor
public class ServiceCenterController {

    private final ServiceCenterService serviceCenterService;

    @PostMapping("/customer")
    public ResponseEntity<Map<String, String>> CustomerDetailController(@Valid @RequestBody CustomerReq customerReq) throws Exception{
        Map<String, String> res;
        serviceCenterService.AddCustomer(customerReq);
        res = ResponseMsg.Msg("Details Added Successfully");

        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/AvailableParts")
    public ResponseEntity<List<AvailableParts>> AvailablePartsController(HttpServletRequest request, HttpServletResponse response){
        List<AvailableParts> parts = serviceCenterService.AvailablePartService(request, response);

        return ResponseEntity.ok().body(parts);
    }

    @PostMapping("/UsePart")
    public ResponseEntity<Map<String, String>> UsePartController(HttpServletRequest request, HttpServletResponse response, String skuId, Integer quantity){
        String res = serviceCenterService.UsePartService(request, response, skuId, quantity);

        return ResponseEntity.ok().body(ResponseMsg.Msg(res));
    }

}
