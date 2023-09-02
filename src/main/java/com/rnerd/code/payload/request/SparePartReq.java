package com.rnerd.code.payload.request;

import com.rnerd.code.models.Globals.Products;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class SparePartReq {

    @NotBlank @Size(max = 100)
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private String Manufacturer;

    @NotBlank
    private String PartType;

    @NotBlank
    private String Model;
}