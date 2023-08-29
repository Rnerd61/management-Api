package com.rnerd.code.services;

import com.rnerd.code.models.WarehouseTeam.Warehouse;
import com.rnerd.code.repository.Warehouse.WarehouseRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepo warehouseRepo;

    public List<Warehouse> getAllWarehouses() {
        return warehouseRepo.findAll();
    }

    public Optional<Warehouse> getWarehouseById(ObjectId id) {
        return warehouseRepo.findById(id);
    }

    public Warehouse createWarehouse(Warehouse warehouse) {
        return warehouseRepo.save(warehouse);
    }

    public Warehouse updateWarehouse(ObjectId id, Warehouse updatedWarehouse) {
        updatedWarehouse.setId(id);
        return warehouseRepo.save(updatedWarehouse);
    }

    public void deleteWarehouse(ObjectId id) {
        warehouseRepo.deleteById(id);
    }
}