package com.rnerd.code.models.PlanningTeam;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "parts")
public class Parts {
    @Id
    private String skuId;  // Unique SKU ID for the part
    private String name;
    private String description;
    private String compatibility;
    private int quantity;
}