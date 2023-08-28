package com.rnerd.code.repository.ServiceCenter;


import com.rnerd.code.models.ServiceTeam.CustomerModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends MongoRepository<CustomerModel, ObjectId> {
    CustomerModel findByCustomerName(String name);
}
