package com.rnerd.code.services;

import com.rnerd.code.models.Globals.RequiredPart;
import com.rnerd.code.models.Globals.Status;
import com.rnerd.code.models.WarehouseTeam.Warehouse;
import com.rnerd.code.models.WarehouseTeam.WarehouseReq;
import com.rnerd.code.repository.Warehouse.WarehouseRepo;
import com.rnerd.code.repository.Warehouse.WarehouseReqRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WarehouseService {


    private final WarehouseRepo warehouseRepo;
    private final WarehouseReqRepo warehouseReqRepo;


    public Integer CheckAvailService(String skuId, char zone){
        Warehouse warehouse = warehouseRepo.findByZone(zone);
        RequiredPart GotPart =  warehouse.getParts().stream().filter(parts -> parts.getSpareParts().getSkuid().equals(skuId)).findFirst().orElse(null);
        if(GotPart!=null){
            return GotPart.getQuantity();
        }
        return 0;
    }

    public String GetReqService(WarehouseReq req){
        if(CheckAvailService(req.getRequiredPart().getSpareParts().getSkuid(), req.getWarehouse().getZone()) < req.getRequiredPart().getQuantity()){
            return "Item Insufficient";
        }
        req.getRequiredPart().setCurrentStatus(Status.FORWARDED);
        warehouseReqRepo.save(req);
        return "Request Added Successfully.";
    }

    public String dispatchService(String skuId) {
        WarehouseReq warehouseReq =  warehouseReqRepo.findBySkuId(skuId);
        warehouseReq.getRequiredPart().setCurrentStatus(Status.DISPACTHED);

        warehouseReqRepo.delete(warehouseReq);

        return "Item Dispatched Successfully";
    }
}