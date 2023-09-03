package com.rnerd.code.payload.request.InitialSetup;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class addWareHouse {

    private String name;

    private char zone;
}
