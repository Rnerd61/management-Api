package com.rnerd.code.repository.Global;

import com.rnerd.code.models.Globals.RequiredPart;
import com.rnerd.code.models.Globals.SpareParts;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequiredPartRepo extends MongoRepository<RequiredPart, ObjectId> {
    RequiredPart findBySpareParts(SpareParts spareParts);
}
