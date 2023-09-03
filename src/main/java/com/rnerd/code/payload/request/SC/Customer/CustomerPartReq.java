package com.rnerd.code.payload.request.SC.Customer;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class CustomerPartReq {
    @NotBlank
    String customerName;

    @NotBlank
    String skuid;
}
