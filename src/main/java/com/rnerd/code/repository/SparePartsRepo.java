package com.rnerd.code.repository;

import com.rnerd.code.models.Globals.SpareParts;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SparePartsRepo extends MongoRepository<SpareParts, ObjectId> {
    SpareParts findBySkuid(String skuid);
}
