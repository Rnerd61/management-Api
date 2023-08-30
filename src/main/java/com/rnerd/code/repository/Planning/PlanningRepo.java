package com.rnerd.code.repository.Planning;

import com.rnerd.code.models.PlanningTeam.Planning;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanningRepo extends MongoRepository<Planning, ObjectId> {

    Planning findByAssignedTo(String name);

    Planning findByTaskName(String name);
}
