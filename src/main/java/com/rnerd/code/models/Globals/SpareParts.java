package com.rnerd.code.models.Globals;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "spareParts")
public class SpareParts {

    @Id
    ObjectId id;

    @NotBlank
    String skuid;

    @NotBlank @Size(max = 100)
    String name;

}
