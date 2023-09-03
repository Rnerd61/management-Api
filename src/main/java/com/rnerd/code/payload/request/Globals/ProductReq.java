package com.rnerd.code.payload.request.Globals;

import com.rnerd.code.models.Globals.SpareParts;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ProductReq {

    @NotBlank @Size(max = 100)
    private String name;

    @NotBlank
    private String Manufacturer;

    @NotBlank
    private String DeviceType;

    @NotBlank String Model;

    @NotBlank
    private String description;


}
