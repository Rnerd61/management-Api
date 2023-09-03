package com.rnerd.code.controllers.Global;

import com.rnerd.code.models.Globals.Products;
import com.rnerd.code.models.Globals.SpareParts;
import com.rnerd.code.payload.request.ProductReq;
import com.rnerd.code.payload.request.SparePartReq;
import com.rnerd.code.payload.request.addPartReq;
import com.rnerd.code.repository.Global.ProductsRepo;
import com.rnerd.code.repository.Global.SparePartsRepo;
import com.rnerd.code.services.GlobalService;
import com.rnerd.code.services.ServiceCenterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.Port;
import java.util.List;

@Controller
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class GlobalController {

    private final GlobalService globalService;
    private final ProductsRepo productsRepo;
    private final SparePartsRepo sparePartsRepo;

    @GetMapping("/getProducts")
    public ResponseEntity<List<Products>> getProducts(){
        return ResponseEntity.ok().body(globalService.getAllProductsService(0));
    }


    @GetMapping("/getProducts/:id")
    public ResponseEntity<Products> getProducts(@RequestParam String skuid){
        return ResponseEntity.ok().body(globalService.getProductService(skuid));
    }

    @GetMapping("/getParts")
    public ResponseEntity<List<SpareParts>> getParts(){
        return ResponseEntity.ok().body(globalService.getAllPartsService(0));
    }


    @GetMapping("/getParts/:id")
    public ResponseEntity<SpareParts> getParts(@RequestParam String skuid){
        return ResponseEntity.ok().body(globalService.getPartsService(skuid));
    }


    @PostMapping("/saveProduct")
    public ResponseEntity<Products> saveProduct(@RequestBody ProductReq req){
        String skuId = globalService.generateSku(req);
        Products newProduct = new Products(skuId, req);
        productsRepo.save(newProduct);

        return ResponseEntity.ok().body(productsRepo.findBySkuid(skuId));
    }

    @PostMapping("/savePart")
    public ResponseEntity<SpareParts> savePart(@RequestBody @Valid SparePartReq req){
        String skuId = globalService.generateSku(req);
        SpareParts newPart = new SpareParts(skuId, req);
        sparePartsRepo.save(newPart);

        return ResponseEntity.ok().body(sparePartsRepo.findBySkuid(skuId));
    }

    @PostMapping("/addPartToModel")
    public ResponseEntity<Products> addPartToModel(@RequestBody @Valid addPartReq req){
        Products product = productsRepo.findBySkuid(req.getProductSkuId());
        product.getSpareParts().add(sparePartsRepo.findBySkuid(req.getPartSkuId()));
        productsRepo.save(product);


        return ResponseEntity.ok().body(productsRepo.findBySkuid(req.getProductSkuId()));
    }
}
