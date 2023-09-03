package com.rnerd.code.payload.request.SC;

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

    @NotBlank @Size(max = 100)
    private String description;

    @DBRef @NotBlank
    private List<RequiredPart> RequiredParts;
}
