package com.rnerd.code.repository.CustomerSupport;

import com.rnerd.code.models.SupportTeam.CustomerSupport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerSupportRepo extends MongoRepository<CustomerSupport, String> {
}
