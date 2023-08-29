package com.rnerd.code.controllers;

import com.rnerd.code.models.WarehouseTeam.Warehouse;
import com.rnerd.code.services.WarehouseService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/wt")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping
    public List<Warehouse> getAllWarehouses() {
        return warehouseService.getAllWarehouses();
    }

    @GetMapping("/{id}")
    public Optional<Warehouse> getWarehouseById(@PathVariable String id) {
        return warehouseService.getWarehouseById(new ObjectId(id));
    }

    @PostMapping
    public Warehouse createWarehouse(@RequestBody Warehouse warehouse) {
        return warehouseService.createWarehouse(warehouse);
    }

    @PutMapping("/{id}")
    public Warehouse updateWarehouse(@PathVariable String id, @RequestBody Warehouse updatedWarehouse) {
        return warehouseService.updateWarehouse(new ObjectId(id), updatedWarehouse);
    }

    @DeleteMapping("/{id}")
    public void deleteWarehouse(@PathVariable String id) {
        warehouseService.deleteWarehouse(new ObjectId(id));
    }
}