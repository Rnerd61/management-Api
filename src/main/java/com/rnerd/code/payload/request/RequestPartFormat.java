package com.rnerd.code.payload.request;

import com.rnerd.code.models.ServiceTeam.AvailableParts;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class RequestPartFormat {

    @NotBlank
    String skuId;

    @NotBlank
    Integer quantity;

    @NotBlank
    private String from;

    @NotBlank @Size(min = 5)
    private String description;

    @DateTimeFormat
    private Date dueDate;

    @DBRef
    private List<AvailableParts> RequiredParts = new ArrayList<>();
}
