package com.rnerd.code.services;


import com.rnerd.code.models.PlanningTeam.Planning;
import com.rnerd.code.models.PlanningTeam.PlanningReq;
import com.rnerd.code.models.WarehouseTeam.WarehouseReq;
import com.rnerd.code.repository.Planning.PlanningRepo;
import com.rnerd.code.repository.Planning.PlanningReqRepo;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanningService {

    private final PlanningRepo planningRepo;
    private final PlanningReqRepo planningReqRepo;
    private final WarehouseService warehouseService;

    public String ForwardReq(WarehouseReq req) {

        return warehouseService.GetReqService(req);
    }

    public List<Planning> getAllPlanningTasks(Integer pageNumber) {
        int page = pageNumber;
        int pageSize = 10;
        Sort sort = Sort.by(Sort.Direction.DESC, "dueDate");


        PageRequest pageRequest = PageRequest.of(page, pageSize, sort);
        Page<Planning> resultPage = planningRepo.findAll(pageRequest);

        return resultPage.getContent();
    }

    public List<PlanningReq> getAllPlanningRequests(Integer pageNumber){
        int page = pageNumber;
        int pageSize = 10;
        Sort sort = Sort.by(Sort.Direction.DESC, "dueDate");


        PageRequest pageRequest = PageRequest.of(page, pageSize, sort);
        Page<PlanningReq> resultPage = planningReqRepo.findAll(pageRequest);

        return resultPage.getContent();
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