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
    ObjectId id;

    @NotBlank
    String ServiceCenterName;

    @NotBlank
    String Zone;

    @DBRef
    List<EmployeeModel> employees = new ArrayList<>();

    @DBRef
    List<AvailableParts> AvailableParts = new ArrayList<>();


}
