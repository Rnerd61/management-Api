package com.rnerd.code.services;

import com.rnerd.code.config.jwt.JwtUtils;
import com.rnerd.code.config.services.UserDetailsImpl;
import com.rnerd.code.config.services.UserDetailsServicesImpl;
import com.rnerd.code.models.Globals.SpareParts;
import com.rnerd.code.models.PlanningTeam.Planning;
import com.rnerd.code.models.PlanningTeam.PlanningReq;
import com.rnerd.code.models.ServiceTeam.AvailableParts;
import com.rnerd.code.models.ServiceTeam.CustomerModel;
import com.rnerd.code.models.ServiceTeam.ServiceCenter;
import com.rnerd.code.payload.request.CustomerReq;
import com.rnerd.code.payload.request.RequestPartFormat;
import com.rnerd.code.repository.Global.SparePartsRepo;
import com.rnerd.code.repository.Planning.PlanningReqRepo;
import com.rnerd.code.repository.ServiceCenter.CustomerRepo;
import com.rnerd.code.repository.ServiceCenter.ServiceCenterRepo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceCenterService {

    private final CustomerRepo customerRepo;
    private final ServiceCenterRepo serviceCenterRepo;
    private final SparePartsRepo sparePartsRepo;
    private final JwtUtils jwtUtils;
    private final UserDetailsServicesImpl userDetailsService;
    private final MongoTemplate mongoTemplate;
    private final PlanningReqRepo planningReqRepo;



    public void AddCustomer(CustomerReq customerReq) throws Exception{
        CustomerModel customerModel = new CustomerModel(customerReq.getCustomerName(), customerReq.getProductId(), customerReq.getEmail());
        customerRepo.insert(customerModel);
    }

    private void AddSparePart(HttpServletRequest request, HttpServletResponse response, String skuId, Integer quantity) throws Exception{

        ServiceCenter serviceCenter = getServiceCenter(request, response);
        AvailableParts ExistingPart = serviceCenter.getAvailableParts().stream().filter(part -> part.getSpareParts().getSkuid().equals(skuId)).findFirst().orElse(null);

        if(ExistingPart != null){
            ExistingPart.setQuantity(ExistingPart.getQuantity() + quantity);
            return;
        }else{
            SpareParts sparePart = sparePartsRepo.findBySkuid(skuId);
            if(sparePart == null){
                throw new Exception("SparePart Not Found");
            }

            AvailableParts newPart = new AvailableParts(sparePart, quantity);

            Query query = new Query(Criteria.where("_id").is(serviceCenter.getId()));
            Update update = new Update().push("AvailableParts", newPart);
            mongoTemplate.updateFirst(query, update, ServiceCenter.class);

            return;
        }
    }

    private ServiceCenter getServiceCenter(HttpServletRequest request, HttpServletResponse response){
        String username = jwtUtils.getUserNameFromJwtToken(jwtUtils.getJwtFromCookies(request));
        UserDetailsImpl Employee = userDetailsService.loadUserByUsername(username);

        return serviceCenterRepo.findByServiceCenterName(Employee.getEmployeeAt());
    }


    // Implement this
    public void RequestPart(HttpServletRequest request, HttpServletResponse response, RequestPartFormat req){


        SpareParts requiredPart = sparePartsRepo.findBySkuid(req.getSkuId());
        AvailableParts partAndQuantity = new AvailableParts(requiredPart, req.getQuantity());
        String serviceCenter = getServiceCenter(request, response).getServiceCenterName();

        PlanningReq RequestedParts = planningReqRepo.findByFrom(serviceCenter);

        if(requiredPart==null){
            RequestedParts = new PlanningReq(serviceCenter, req.getDescription(), req.getDueDate(), partAndQuantity);
        }else {
            RequestedParts.getRequiredParts().add(partAndQuantity);
        }

        PlanningReqRepo.save(RequestedParts);
        return;
    }

    public String UsePartService(HttpServletRequest request, HttpServletResponse response, String skuId, Integer quantity){
        ServiceCenter serviceCenter = getServiceCenter(request, response);
        AvailableParts ExistingPart = serviceCenter.getAvailableParts().stream().filter(part -> part.getSpareParts().getSkuid().equals(skuId)).findFirst().orElse(null);

        if(ExistingPart == null || ExistingPart.getQuantity() < quantity){
            Integer reqQuantity = 0;
            if(ExistingPart != null){
                reqQuantity = quantity - ExistingPart.getQuantity();
            }

            return String.format("Item sortage Detacted, Request %d parts of skuid %s", reqQuantity, skuId);


        }else {
            ExistingPart.setQuantity(ExistingPart.getQuantity() - quantity);
            return "SpareParts Used Successfully";
        }

    }

    public List<AvailableParts> AvailablePartService(HttpServletRequest request, HttpServletResponse response){
        ServiceCenter serviceCenter = getServiceCenter(request, response);
        return serviceCenter.getAvailableParts();
    }



}
