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
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

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

    public void AddSparePart(HttpServletRequest request, HttpServletResponse response, String skuId, Integer quantity) throws Exception{
        if(serviceCenterRepo.doesSparePartExist(skuId)){
            UpdateSparePart(skuId, quantity);
            return;
        }else{
            SpareParts sparePart = sparePartsRepo.findBySkuid(skuId);
            AvailableParts newPart = new AvailableParts(sparePart, quantity);

            String username = jwtUtils.getUserNameFromJwtToken(jwtUtils.getJwtFromCookies(request));
            UserDetailsImpl Employee = userDetailsService.loadUserByUsername(username);

            ServiceCenter serviceCenter = serviceCenterRepo.findByServiceCenterName(Employee.getEmployeeAt());

            Query query = new Query(Criteria.where("_id").is(serviceCenter.getId()));
            Update update = new Update().push("AvailableParts", newPart);
            mongoTemplate.updateFirst(query, update, ServiceCenter.class);

            return;
        }
    }

    public void UpdateSparePart(String skuId, Integer quantity){

        AvailableParts ExistingPart = serviceCenterRepo.findPartBySkuId(skuId);
        ExistingPart.setQuantity(ExistingPart.getQuantity() + quantity);

        return;
    }

}
