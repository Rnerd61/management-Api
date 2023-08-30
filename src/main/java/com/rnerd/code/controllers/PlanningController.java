package com.rnerd.code.controllers;

import com.rnerd.code.models.PlanningTeam.Planning;
import com.rnerd.code.services.PlanningService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pt")
public class PlanningController {

    @Autowired
    private PlanningService planningService;

    @GetMapping
    public List<Planning> getAllPlanningTasks(@RequestBody Map<String, Integer> req) {
        return planningService.getAllPlanningTasks(req.get("pageNumber"));
    }

    @PostMapping
    public Planning createPlanningTask(@RequestBody Planning planning) {
        return planningService.createPlanningTask(planning);
    }

    @GetMapping("/{id}")
    public Planning getPlanningTaskById(@PathVariable ObjectId id) {
        return planningService.getPlanningTaskById(id);
    }

    @PutMapping("/{id}")
    public Planning updatePlanningTask(@PathVariable ObjectId id, @RequestBody Planning updatedPlanning) {
        return planningService.updatePlanningTask(id, updatedPlanning);
    }

    @DeleteMapping("/{id}")
    public void deletePlanningTask(@PathVariable ObjectId id) {
        planningService.deletePlanningTask(id);
    }
}