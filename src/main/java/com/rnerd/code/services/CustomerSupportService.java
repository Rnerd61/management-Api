package com.rnerd.code.services;

import com.rnerd.code.models.SupportTeam.CustomerSupport;
import com.rnerd.code.repository.CustomerSupport.CustomerSupportRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerSupportService {

    @Autowired
    private CustomerSupportRepo customerSupportRepo;

    public List<CustomerSupport> getAllInquiries() {
        return customerSupportRepo.findAll();
    }

    public Optional<CustomerSupport> getInquiryById(String id) {
        return customerSupportRepo.findById(id);
    }

    public CustomerSupport createInquiry(CustomerSupport inquiry) {
        return customerSupportRepo.save(inquiry);
    }

    public CustomerSupport updateInquiry(ObjectId id, CustomerSupport updatedInquiry) {
        updatedInquiry.setId(id);
        return customerSupportRepo.save(updatedInquiry);
    }

    public void deleteInquiry(String id) {
        customerSupportRepo.deleteById(id);
    }
}
