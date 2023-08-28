package com.rnerd.code.services;

import com.rnerd.code.models.ServiceTeam.CustomerModel;
import com.rnerd.code.payload.request.CustomerReq;
import com.rnerd.code.repository.ServiceCenter.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
public class ServiceCenterService {

    private final CustomerRepo customerRepo;
    public void AddCustomer(CustomerReq customerReq) throws Exception{
        CustomerModel customerModel = new CustomerModel(customerReq.getCustomerName(), customerReq.getProductId(), customerReq.getEmail());
        customerRepo.insert(customerModel);
    }

    public void AddSparePart(String skuId, Integer count) throws Exception{

    }
}
