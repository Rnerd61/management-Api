package com.rnerd.code.controllers;

import com.rnerd.code.models.Globals.Products;
import com.rnerd.code.models.Globals.SpareParts;
import com.rnerd.code.services.GlobalService;
import com.rnerd.code.services.ServiceCenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class GlobalController {

    private final GlobalService globalService;

    @GetMapping("/getProduct")
    public ResponseEntity<List<Products>> getProducts(){
        return ResponseEntity.ok().body(globalService.getAllProductsService(10));
    }


    @GetMapping("/getProduct/:id")
    public ResponseEntity<Products> getProducts(@RequestParam String skuid){
        return ResponseEntity.ok().body(globalService.getProductService(skuid));
    }

    @GetMapping("/getParts")
    public ResponseEntity<List<Products>> getParts(){
        return ResponseEntity.ok().body(globalService.getAllProductsService(10));
    }


    @GetMapping("/getParts/:id")
    public ResponseEntity<SpareParts> getParts(@RequestParam String skuid){
        return ResponseEntity.ok().body(globalService.getPartsService(skuid));
    }

}
