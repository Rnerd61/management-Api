package com.rnerd.code.controllers.Global;

import com.rnerd.code.models.Globals.Products;
import com.rnerd.code.models.Globals.RequiredPart;
import com.rnerd.code.models.Globals.SpareParts;
import com.rnerd.code.models.ServiceTeam.ServiceCenter;
import com.rnerd.code.models.WarehouseTeam.Warehouse;
import com.rnerd.code.models.WarehouseTeam.WarehouseReq;
import com.rnerd.code.repository.Global.ProductsRepo;
import com.rnerd.code.repository.Global.RequiredPartRepo;
import com.rnerd.code.repository.Global.SparePartsRepo;
import com.rnerd.code.repository.ServiceCenter.ServiceCenterRepo;
import com.rnerd.code.repository.Warehouse.WarehouseRepo;
import com.rnerd.code.services.GlobalService;
import com.rnerd.code.services.ServiceCenterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://172.31.52.191:3000", maxAge = 3000, allowCredentials = "true")
@RequiredArgsConstructor
public class GlobalController {

    private final GlobalService globalService;

    @GetMapping("/getProducts")
    public ResponseEntity<List<Products>> getProducts(){
        return ResponseEntity.ok().body(globalService.getAllProductsService(0));
    }


    @GetMapping("/getProducts/{skuid}")
    public ResponseEntity<Products> getProducts(@PathVariable String skuid){
        return ResponseEntity.ok().body(globalService.getProductService(skuid));
    }

    @GetMapping("/getParts")
    public ResponseEntity<List<SpareParts>> getParts(){
        return ResponseEntity.ok().body(globalService.getAllPartsService(0));
    }


    @GetMapping("/getParts/{skuid}")
    public ResponseEntity<SpareParts> getParts(@PathVariable String skuid){
        return ResponseEntity.ok().body(globalService.getPartsService(skuid));
    }


//    @PostMapping("/saveProduct")
//    public ResponseEntity<Products> saveProduct(@RequestBody ProductReq req){
//        String skuId = globalService.generateSku(req);
//        Products newProduct = new Products(skuId, req);
//        productsRepo.save(newProduct);
//
//        return ResponseEntity.ok().body(productsRepo.findBySkuid(skuId));
//    }
//
//    @PostMapping("/savePart")
//    public ResponseEntity<SpareParts> savePart(@RequestBody @Valid SparePartReq req){
//        String skuId = globalService.generateSku(req);
//        SpareParts newPart = new SpareParts(skuId, req);
//        sparePartsRepo.save(newPart);
//
//        return ResponseEntity.ok().body(sparePartsRepo.findBySkuid(skuId));
//    }
//
//    @PostMapping("/addPartToModel")
//    public ResponseEntity<Products> addPartToModel(@RequestBody @Valid addPartReq req){
//        Products product = productsRepo.findBySkuid(req.getProductSkuId());
//        product.getSpareParts().add(sparePartsRepo.findBySkuid(req.getPartSkuId()));
//        productsRepo.save(product);
//
//
//        return ResponseEntity.ok().body(productsRepo.findBySkuid(req.getProductSkuId()));
//    }
//
//    @PostMapping("/addServiceCenter")
//    public ResponseEntity<ServiceCenter> addServiceCenter(@RequestBody @Valid addServiceCenterReq req){
//        ServiceCenter newServiceCenter = new ServiceCenter(req);
//        serviceCenterRepo.insert(newServiceCenter);
//        return ResponseEntity.ok().body(newServiceCenter);
//    }
//
//    @PostMapping("/addWareHouse")
//    public ResponseEntity<Warehouse> addServiceCenter(@RequestBody @Valid addWareHouse req){
//        Warehouse newWareHouse = new Warehouse(req);
//        warehouseRepo.insert(newWareHouse);
//        return ResponseEntity.ok().body(newWareHouse);
//    }
//
//    @GetMapping("/addPartWarehouse")
//    public ResponseEntity<String> addPartWareHouse(){
//        List<SpareParts> spareParts = sparePartsRepo.findAll();
////        List<RequiredPart> requiredParts = new ArrayList<>();
//
//        spareParts.stream().forEach(sparePart -> {
//            RequiredPart requiredPart = new RequiredPart(sparePart, 20);
//            requiredPartRepo.insert(requiredPart);
//        });
//
//        List<Warehouse> warehouses = warehouseRepo.findAll();
//
//        warehouses.stream().forEach(warehouse -> {
//            spareParts.stream().forEach(sparePart -> {
//                RequiredPart requiredPart = new RequiredPart(sparePart, 20);
//                requiredPartRepo.insert(requiredPart);
//                warehouse.getParts().add(requiredPart);
//                warehouseRepo.save(warehouse);
//            });
//        });
//
//        return ResponseEntity.ok().body("items Added");
//    }
}
