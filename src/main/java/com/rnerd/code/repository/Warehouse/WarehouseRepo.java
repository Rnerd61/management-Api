package com.rnerd.code.repository.Warehouse;

import com.rnerd.code.models.WarehouseTeam.Warehouse;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepo extends MongoRepository<Warehouse, ObjectId> {

}
