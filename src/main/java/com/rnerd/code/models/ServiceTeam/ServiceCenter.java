package com.rnerd.code.models.ServiceTeam;


import com.rnerd.code.models.Globals.EmployeeModel;
import com.rnerd.code.models.Globals.SpareParts;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document(collection = "ServiceCenter")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceCenter {

    @Id
    private ObjectId id;

    @NotBlank
    private String ServiceCenterName;

    @NotBlank
    private String Zone;

    @NotBlank
    private String Address;

    @DBRef
    private List<EmployeeModel> employees = new ArrayList<>();

    @DBRef
    private List<AvailableParts> AvailableParts = new ArrayList<>();

}
