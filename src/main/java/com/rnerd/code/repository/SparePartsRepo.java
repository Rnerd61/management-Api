package com.rnerd.code.repository;

import com.rnerd.code.models.spareParts;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SparePartsRepo extends MongoRepository<spareParts, ObjectId> {
    spareParts findBySkuid(String skuid);
}
