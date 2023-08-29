package com.rnerd.code.services;

import com.rnerd.code.config.jwt.JwtUtils;
import com.rnerd.code.config.services.UserDetailsImpl;
import com.rnerd.code.config.services.UserDetailsServicesImpl;
import com.rnerd.code.models.Globals.EmployeeModel;
import com.rnerd.code.models.Globals.SpareParts;
import com.rnerd.code.models.ServiceTeam.AvailableParts;
import com.rnerd.code.models.ServiceTeam.CustomerModel;
import com.rnerd.code.models.ServiceTeam.ServiceCenter;
import com.rnerd.code.payload.request.CustomerReq;
import com.rnerd.code.repository.Global.SparePartsRepo;
import com.rnerd.code.repository.ServiceCenter.CustomerRepo;
import com.rnerd.code.repository.ServiceCenter.ServiceCenterRepo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

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

    public void AddCustomer(CustomerReq customerReq) throws Exception{
        CustomerModel customerModel = new CustomerModel(customerReq.getCustomerName(), customerReq.getProductId(), customerReq.getEmail());
        customerRepo.insert(customerModel);
    }

    private void AddSparePart(HttpServletRequest request, HttpServletResponse response, String skuId, Integer quantity) throws Exception{

        ServiceCenter serviceCenter = getSeriveCenter(request, response);
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

    private ServiceCenter getSeriveCenter(HttpServletRequest request, HttpServletResponse response){
        String username = jwtUtils.getUserNameFromJwtToken(jwtUtils.getJwtFromCookies(request));
        UserDetailsImpl Employee = userDetailsService.loadUserByUsername(username);

        return serviceCenterRepo.findByServiceCenterName(Employee.getEmployeeAt());
    }


    // Implement this
    public void RequestPart(String skuId, Integer quantity){
        return;
    }

    public String UsePartService(HttpServletRequest request, HttpServletResponse response, String skuId, Integer quantity){
        ServiceCenter serviceCenter = getSeriveCenter(request, response);
        AvailableParts ExistingPart = serviceCenter.getAvailableParts().stream().filter(part -> part.getSpareParts().getSkuid().equals(skuId)).findFirst().orElse(null);

        if(ExistingPart == null || ExistingPart.getQuantity() < quantity){
            Integer reqQuantity = 0;
            if(ExistingPart != null){
                reqQuantity = quantity - ExistingPart.getQuantity();
            }
            RequestPart(skuId, reqQuantity);
            return "SparePart Shortage Detacted, New Parts Requested";


        }else {
            ExistingPart.setQuantity(ExistingPart.getQuantity() - quantity);
            return "SpareParts Used Successfully";
        }

    }

    public List<AvailableParts> AvailablePartService(HttpServletRequest request, HttpServletResponse response){
        ServiceCenter serviceCenter = getSeriveCenter(request, response);
        return serviceCenter.getAvailableParts();
    }



}
