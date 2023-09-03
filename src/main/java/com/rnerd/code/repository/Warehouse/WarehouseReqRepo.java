package com.rnerd.code.repository.Warehouse;

import com.rnerd.code.models.Globals.RequiredPart;
import com.rnerd.code.models.WarehouseTeam.Warehouse;
import com.rnerd.code.models.WarehouseTeam.WarehouseReq;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.ObjectInput;

@Repository
public interface WarehouseReqRepo extends MongoRepository<WarehouseReq, ObjectId> {
    WarehouseReq findByRequiredPart(RequiredPart requiredPart);
}
