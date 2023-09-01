package com.rnerd.code.payload.request;

import com.rnerd.code.models.Globals.RequiredPart;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
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

    @DBRef
    private List<RequiredPart> RequiredParts = new ArrayList<>();
}
