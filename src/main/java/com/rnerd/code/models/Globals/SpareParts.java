package com.rnerd.code.models.Globals;

import com.rnerd.code.payload.request.Globals.SparePartReq;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "spareParts")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class SpareParts {

//    @Id
//    private ObjectId id;

    @Id @Indexed(unique = true) @NotBlank
    private String skuid;

    @NotBlank @Size(max = 100)
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private String Manufacturer;

    @NotBlank
    private String PartType;

    @NotBlank String Model;

    @NotBlank @DateTimeFormat
    private Date releaseDate;


    public SpareParts(String skuid, SparePartReq req) {
        this.skuid = skuid;
        this.name = req.getName();
        this.Manufacturer = req.getManufacturer();
        this.PartType = req.getPartType();
        this.Model = req.getModel();
        this.description = req.getDescription();
        this.releaseDate = new Date();
    }

}
