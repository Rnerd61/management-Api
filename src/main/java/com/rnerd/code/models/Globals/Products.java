package com.rnerd.code.models.Globals;

import com.rnerd.code.payload.request.ProductReq;
import com.rnerd.code.payload.request.SparePartReq;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "Products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Products  {

//    @Id
//    private ObjectId id;

    @Id
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

    @DBRef
    private List<SpareParts> spareParts = new ArrayList<>();

    public Products(String name, String manufacturer, String deviceType, String model, String description) {
        this.name = name;
        Manufacturer = manufacturer;
        DeviceType = deviceType;
        Model = model;
        this.description = description;
        this.releaseDate = new Date();
    }

    public Products(String skuid, ProductReq req) {
        this.skuid = skuid;
        this.name = req.getName();
        Manufacturer = req.getManufacturer();
        DeviceType = req.getDeviceType();
        Model = req.getModel();
        this.description = req.getDescription();
        this.releaseDate = new Date();
    }

}