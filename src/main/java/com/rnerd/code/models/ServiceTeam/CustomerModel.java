package com.rnerd.code.models.ServiceTeam;


import com.rnerd.code.models.Globals.SpareParts;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "CustomerDetails")
@AllArgsConstructor
@NoArgsConstructor
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


    public CustomerModel(String customerName, String productId, String email) {
        CustomerName = customerName;
        ProductId = productId;
        Email = email;
    }
}
