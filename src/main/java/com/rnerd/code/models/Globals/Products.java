package com.rnerd.code.models.Globals;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Document(collection = "Products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Products  {

    @Id
    private ObjectId id;

    @NotBlank
    private String skuid;

    @NotBlank @Size(max = 100)
    private String name;

    @NotBlank
    private String Manufacturer;

    @NotBlank
    private String DeviceType;

    @NotBlank String Model;

    @NotBlank
    private String description;

    @NotBlank @DateTimeFormat
    private Date releaseDate;

    @NotBlank @DBRef
    private List<SpareParts> spareParts;
}