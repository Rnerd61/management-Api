package com.rnerd.code.models.Globals;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "spareParts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpareParts {

    @Id
    ObjectId id;

    @NotBlank
    String skuid;

    @NotBlank @Size(max = 100)
    String name;

}
