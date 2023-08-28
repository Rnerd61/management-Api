package com.rnerd.code.repository.ServiceCenter;

import com.rnerd.code.models.ServiceTeam.AvailableParts;
import com.rnerd.code.models.ServiceTeam.ServiceCenter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceCenterRepo extends MongoRepository<ServiceCenter, ObjectId> {

    @Query(value = "{'AvailableParts.spareParts.skuid': ?0}")
    boolean doesSparePartExist(String skuid);

    @Query(value = "{'AvailableParts.spareParts.skuid': ?0}", fields = "{'AvailableParts.$': 1}")
    AvailableParts findPartBySkuId(String skuid);

}
