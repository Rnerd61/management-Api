package com.rnerd.code.models.Globals;

import com.rnerd.code.payload.request.ProductReq;
import com.rnerd.code.payload.request.SkuGenerationService;
import com.rnerd.code.payload.request.SparePartReq;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Document(collection = "spareParts")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class SpareParts {

    @Id
    private ObjectId id;

    @Indexed(unique = true) @NotBlank
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

    @NotBlank @DBRef
    private List<Products> products;


    public SpareParts(String skuid, SparePartReq req) {
        this.skuid = skuid;
        this.name = req.getName();
        this.Manufacturer = req.getManufacturer();
        this.PartType = req.getPartType();
        Model = req.getModel();
        this.description = req.getDescription();
        this.releaseDate = new Date();
    }

}
