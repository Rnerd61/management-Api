package com.rnerd.code.repository.Planning;

import com.rnerd.code.models.PlanningTeam.PlanningReq;
import jakarta.validation.constraints.NotBlank;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PlanningReqRepo extends MongoRepository<PlanningReq, ObjectId> {

    PlanningReq findByFrom(@NotBlank String from);


}
