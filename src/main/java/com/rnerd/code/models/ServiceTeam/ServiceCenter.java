package com.rnerd.code.models.ServiceTeam;


import com.rnerd.code.models.Globals.RequiredPart;
import com.rnerd.code.payload.request.InitialSetup.addServiceCenterReq;
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

@Document(collection = "ServiceCenter")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceCenter {

    @Id
    private ObjectId id;

    @NotBlank
    private String serviceCenterName;

    @NotBlank
    private String zone;

    @NotBlank
    private String address;

    private List<String> employees = new ArrayList<>();

    @DBRef
    private List<RequiredPart> RequiredPart = new ArrayList<>();

    @DBRef List<CustomerModel> customers = new ArrayList<>();

    public ServiceCenter(addServiceCenterReq req) {
        serviceCenterName = req.getServiceCenterName();
        zone = req.getZone();
        address = req.getAddress();
    }

}
