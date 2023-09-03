package com.rnerd.code.models.ServiceTeam;


import com.rnerd.code.models.Globals.SpareParts;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "CustomerDetails")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomerModel {

    @Id
    private ObjectId id;

    @NotBlank @Indexed(unique = true)
    private String customerName;

    @NotBlank
    private String productId;

    @NotBlank @Email
    private String email;

    @DBRef
    private List<SpareParts> SparePartsRequired = new ArrayList<>();


    public CustomerModel(String customerName, String productId, String email) {
        this.customerName = customerName;
        this.productId = productId;
        this.email = email;
    }
}
