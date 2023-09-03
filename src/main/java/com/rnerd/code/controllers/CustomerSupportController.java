package com.rnerd.code.controllers;

import com.rnerd.code.models.SupportTeam.CustomerSupport;
import com.rnerd.code.services.CustomerSupportService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "http://localhost:3000", maxAge = 3000, allowCredentials = "true")
@RequestMapping("/api/v1/cs")
public class CustomerSupportController {

    @Autowired
    private CustomerSupportService customerSupportService;

    @GetMapping
    public List<CustomerSupport> getAllInquiries() {
        return customerSupportService.getAllInquiries();
    }

    @GetMapping("/hello")
    public ResponseEntity<String> sendHello() {
        return ResponseEntity.ok().body("Hello");
    }

    @GetMapping("/{id}")
    public Optional<CustomerSupport> getInquiryById(@PathVariable String id) {
        return customerSupportService.getInquiryById(id);
    }

    @PostMapping
    public CustomerSupport createInquiry(@RequestBody CustomerSupport inquiry) {
        return customerSupportService.createInquiry(inquiry);
    }

    @PutMapping("/{id}")
    public CustomerSupport updateInquiry(@PathVariable ObjectId id, @RequestBody CustomerSupport updatedInquiry) {
        return customerSupportService.updateInquiry(id, updatedInquiry);
    }

    @DeleteMapping("/{id}")
    public void deleteInquiry(@PathVariable String id) {
        customerSupportService.deleteInquiry(id);
    }
}