package com.rnerd.code.models.SupportTeam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "customer_support")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSupport {
    @Id
    private ObjectId id;
    private String customerName;
    private String inquiry;
    private Date inquiryDate;
    private String repairOrderId;
    // model
    // parts required
}
