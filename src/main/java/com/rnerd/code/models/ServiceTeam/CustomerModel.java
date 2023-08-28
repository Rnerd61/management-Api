package com.rnerd.code.models.ServiceTeam;


import com.rnerd.code.models.Globals.SpareParts;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "CustomerDetails")
public class CustomerModel {

    @Id
    ObjectId id;

    @NotBlank
    String CustomerName;

    @NotBlank
    String ProductId;

    @NotBlank @Email
    String Email;

    @DBRef
    List<SpareParts> SparePartsRequired = new ArrayList<>();
}
