package com.rnerd.code.repository.Global;

import com.rnerd.code.models.Globals.Products;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsRepo extends MongoRepository<Products, ObjectId> {
    Products findBySkuid(String skuid);

    long countBySkuidStartingWith(String baseSku);
}
