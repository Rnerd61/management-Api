package com.rnerd.code.controllers;

import com.rnerd.code.models.PlanningTeam.Planning;
import com.rnerd.code.models.PlanningTeam.PlanningReq;
import com.rnerd.code.services.PlanningService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pt")
public class PlanningController {

    private final PlanningService planningService;

    @GetMapping
    public List<Planning> getAllPlanningTasks(@RequestBody Map<String, Integer> req) {
        return planningService.getAllPlanningTasks(req.get("pageNumber"));
    }

    @GetMapping("/reqs")
    public List<PlanningReq> getAllPlanningRequests(@RequestBody Map<String, Integer> req){
        return planningService.getAllPlanningRequests(req.get("pageNumber"));
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