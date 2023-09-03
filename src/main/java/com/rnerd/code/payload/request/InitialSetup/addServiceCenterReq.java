package com.rnerd.code.payload.request.InitialSetup;

import com.rnerd.code.models.Globals.RequiredPart;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class addServiceCenterReq {
    @NotBlank
    private String ServiceCenterName;

    @NotBlank
    private String Zone;

    @NotBlank
    private String Address;

}
