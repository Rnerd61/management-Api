package com.rnerd.code.controllers.RoleBased;

import com.rnerd.code.models.PlanningTeam.Planning;
import com.rnerd.code.models.PlanningTeam.PlanningReq;
import com.rnerd.code.models.WarehouseTeam.WarehouseReq;
import com.rnerd.code.payload.request.PT.GetAllPlanningTasksReq;
import com.rnerd.code.payload.response.ResponseMsg;
import com.rnerd.code.services.PlanningService;
import com.rnerd.code.services.WarehouseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://172.31.52.191:3000", maxAge = 3000, allowCredentials = "true")
@RequestMapping("/api/v1/pt")
public class PlanningController {

    private final PlanningService planningService;

    @GetMapping
    public List<Planning> getAllPlanningTasks(@RequestBody @Valid GetAllPlanningTasksReq req) {
        return planningService.getAllPlanningTasks(req.getPageNumber());
    }

    @GetMapping("/getRequests")
    public List<PlanningReq> getAllPlanningRequests(@RequestBody GetAllPlanningTasksReq req){
        return planningService.getAllPlanningRequests(req.getPageNumber());
    }

    @PostMapping("/forward")
    public ResponseEntity<Map<String, String>> forwardReqController(@RequestBody WarehouseReq req){
        String res = planningService.ForwardReq(req);
        return ResponseEntity.ok().body(ResponseMsg.Msg(res));
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