package com.rnerd.code.repository;

import com.rnerd.code.models.products;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends MongoRepository<products, ObjectId> {
    products findBySkuId(String skuid);

}
