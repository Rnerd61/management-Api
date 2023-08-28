package com.rnerd.code.repository;

import com.rnerd.code.models.Globals.EmployeeModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepo extends MongoRepository<EmployeeModel, ObjectId> {
    EmployeeModel findByUsername(String username);
    EmployeeModel findByEmail(String email);
}
