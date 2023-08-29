package com.rnerd.code.services;


import com.rnerd.code.models.PlanningTeam.Planning;
import com.rnerd.code.repository.Planning.PlanningRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanningService {

    @Autowired
    private PlanningRepo planningRepo;

    public List<Planning> getAllPlanningTasks() {
        return planningRepo.findAll();
    }

    public Planning createPlanningTask(Planning planning) {
        return planningRepo.save(planning);
    }

    public Planning getPlanningTaskById(ObjectId id) {
        return planningRepo.findById(id).orElse(null);
    }

    public Planning updatePlanningTask(ObjectId id, Planning updatedPlanning) {
        updatedPlanning.setId(id);
        return planningRepo.save(updatedPlanning);
    }

    public void deletePlanningTask(ObjectId id) {
        planningRepo.deleteById(id);
    }
}