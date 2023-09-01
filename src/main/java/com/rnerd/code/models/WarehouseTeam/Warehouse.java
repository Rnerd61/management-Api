package com.rnerd.code.models.WarehouseTeam;

import com.rnerd.code.models.Globals.RequiredPart;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "warehouse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Warehouse {
    @Id
    private ObjectId id;

    @NotBlank
    private String name;

    @NotBlank
    private char zone;

    @DBRef
    private List<RequiredPart> parts;

}
