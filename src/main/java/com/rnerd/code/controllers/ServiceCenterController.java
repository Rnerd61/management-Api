package com.rnerd.code.controllers;

import com.rnerd.code.models.Globals.RequiredPart;
import com.rnerd.code.models.Globals.SpareParts;
import com.rnerd.code.models.ServiceTeam.CustomerModel;
import com.rnerd.code.payload.request.CustomerPartReq;
import com.rnerd.code.payload.request.CustomerReq;
import com.rnerd.code.payload.request.RequestPartFormat;
import com.rnerd.code.payload.response.ResponseMsg;
import com.rnerd.code.repository.ServiceCenter.CustomerRepo;
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
@CrossOrigin(value = "http://localhost:3000", maxAge = 3000, allowCredentials = "true")
@RequestMapping("/api/v1/sc")
@RequiredArgsConstructor
public class ServiceCenterController {

    private final ServiceCenterService serviceCenterService;

    @PostMapping("/customer")
    public ResponseEntity<Map<String, String>> CustomerDetailController(@Valid @RequestBody CustomerReq customerReq) throws Exception{
        Map<String, String> res;

        res = ResponseMsg.Msg(serviceCenterService.AddCustomer(customerReq));

        return ResponseEntity.ok().body(res);
    }

    @PostMapping("/customerRequiredPart")
    public ResponseEntity<Map<String, String>> CustomerDetailController(@RequestBody @Valid CustomerPartReq req) throws Exception{
        Map<String, String> res;
        serviceCenterService.AddCustomerRequirement(req.getCustomerName(), req.getSkuid());
        res = ResponseMsg.Msg("Details Added Successfully");

        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/AvailableParts")
    public ResponseEntity<List<RequiredPart>> AvailablePartsController(HttpServletRequest request, HttpServletResponse response){
        List<RequiredPart> parts = serviceCenterService.AvailablePartService(request, response);

        return ResponseEntity.ok().body(parts);
    }

    @PostMapping("/UsePart")
    public ResponseEntity<Map<String, String>> UsePartController(HttpServletRequest request, HttpServletResponse response, String skuId, Integer quantity){
        String res = serviceCenterService.UsePartService(request, response, skuId, quantity);

        return ResponseEntity.ok().body(ResponseMsg.Msg(res));
    }

    @PostMapping("/ReqPart")
    public ResponseEntity<Map<String, String>> ReqPartController(HttpServletRequest request, HttpServletResponse response, @RequestBody @Valid RequestPartFormat planningReq) throws Exception{
        serviceCenterService.RequestPart(request, response, planningReq);
        return ResponseEntity.ok().body(ResponseMsg.Msg("Part Requested!"));
    }

}
