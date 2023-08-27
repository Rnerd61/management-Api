package com.rnerd.code.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class products {

    @Id
    ObjectId id;

    @Indexed(unique = true) @NotBlank
    String skuId;

    @NotBlank @Size(min=3, max = 100)
    String name;

    @DBRef
    Set<spareParts> sparePartsList = new HashSet<>();
}
