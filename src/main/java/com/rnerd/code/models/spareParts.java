package com.rnerd.code.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "spareParts")
public class spareParts {

    @Id
    ObjectId id;

    @NotBlank
    String skuid;

    @NotBlank @Size(max = 100)
    String name;

}
