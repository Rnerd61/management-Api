package com.rnerd.code.models.WarehouseTeam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "warehouses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Warehouse {
    @Id
    private ObjectId id;
    private String name;
    private String location;
    private List<Parts> parts;
    // contracts/orders implementation

    public Warehouse(String name, String location, List<Parts> parts) {
        this.name = name;
        this.location = location;
        this.parts = parts;
    }
}
