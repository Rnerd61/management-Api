package com.rnerd.code.repository;

import com.rnerd.code.models.UserModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepo extends MongoRepository<UserModel, ObjectId> {
    UserModel findByUsername(String username);
    UserModel findByEmail(String email);
}
