package com.rnerd.code.models.WarehouseTeam;

import com.rnerd.code.models.Globals.RequiredPart;
import com.rnerd.code.models.Globals.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@Document(collection = "WareHouseReq")
public class WarehouseReq {
    @Id
    ObjectId id;

    @NotBlank
    private String from;

    @NotBlank
    private Warehouse warehouse;

    @NotBlank @Size(min = 5)
    private String description;

    @DateTimeFormat
    private DateTimeFormat CreatedAt;

    @DBRef
    private RequiredPart requiredPart;

    @NotBlank
    private String skuId;

    public WarehouseReq(ObjectId id, String from, Warehouse warehouse, String description, DateTimeFormat createdAt, RequiredPart requiredPart) {
        this.id = id;
        this.from = from;
        this.warehouse = warehouse;
        this.description = description;
        this.CreatedAt = createdAt;
        this.requiredPart = requiredPart;
        this.skuId = requiredPart.getSpareParts().getSkuid();
    }
}
