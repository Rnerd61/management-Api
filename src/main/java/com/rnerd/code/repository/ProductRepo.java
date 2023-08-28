package com.rnerd.code.repository;

import com.rnerd.code.models.Globals.Products;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends MongoRepository<Products, ObjectId> {
    Products findBySkuId(String skuid);

}
