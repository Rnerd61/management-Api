package com.rnerd.code.repository.Planning;

import com.rnerd.code.models.PlanningTeam.PlanningReq;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanningReqRepo extends MongoRepository<PlanningReq, ObjectId> {

    PlanningReq findByFrom(String name);

}
