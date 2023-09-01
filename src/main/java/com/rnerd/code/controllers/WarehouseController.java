package com.rnerd.code.controllers;

import com.rnerd.code.models.WarehouseTeam.WarehouseReq;
import com.rnerd.code.payload.response.ResponseMsg;
import com.rnerd.code.repository.Warehouse.WarehouseRepo;
import com.rnerd.code.services.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/wt")
public class WarehouseController {

    private final WarehouseService warehouseService;
    private final WarehouseRepo warehouseRepo;


    @GetMapping("/AvailabilityCheck")
    public ResponseEntity<Map<String, Integer>> CheckAvailabity(@RequestBody String skuId, char zone){
        Map<String, Integer> res = new HashMap<>();
        res.put(skuId, warehouseService.CheckAvailService(skuId, zone));
        return ResponseEntity.ok().body(res);
    }
    @GetMapping("/dispatch/:skuid")
    public ResponseEntity<Map<String, String>> Dispatch(@RequestParam String skuid){
        return ResponseEntity.ok().body(ResponseMsg.Msg(warehouseService.dispatchService(skuid)));
    }
}