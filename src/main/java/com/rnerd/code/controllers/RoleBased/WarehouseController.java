package com.rnerd.code.controllers.RoleBased;

import com.rnerd.code.models.Globals.Status;
import com.rnerd.code.models.WarehouseTeam.WarehouseReq;
import com.rnerd.code.payload.response.ResponseMsg;
import com.rnerd.code.repository.Warehouse.WarehouseRepo;
import com.rnerd.code.repository.Warehouse.WarehouseReqRepo;
import com.rnerd.code.services.ServiceCenterService;
import com.rnerd.code.services.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://172.31.52.191:3000", maxAge = 3000, allowCredentials = "true")
@RequestMapping("/api/v1/wt")
public class WarehouseController {

    private final WarehouseService warehouseService;
    private final WarehouseRepo warehouseRepo;
    private final WarehouseReqRepo warehouseReqRepo;
    private final ServiceCenterService serviceCenterService;


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

    @GetMapping("/delivered/:skuid")
    public ResponseEntity<Map<String, String>> delivered(@RequestParam String skuid) throws Exception{
        WarehouseReq req = warehouseReqRepo.findBySkuId(skuid);
        serviceCenterService.AddSparePart(req.getFrom(), req.getRequiredPart().getSpareParts().getSkuid(), req.getRequiredPart().getQuantity());
        req.getRequiredPart().setCurrentStatus(Status.COMPLETED);
        warehouseReqRepo.delete(req);

        return ResponseEntity.ok().body(ResponseMsg.Msg("Item Delivered Successfully"));
    }
}