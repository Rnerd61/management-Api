package com.rnerd.code.repository.ServiceCenter;

import com.rnerd.code.models.Globals.RequiredPart;
import com.rnerd.code.models.ServiceTeam.ServiceCenter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceCenterRepo extends MongoRepository<ServiceCenter, ObjectId> {


    ServiceCenter findByServiceCenterName(String name);
}
