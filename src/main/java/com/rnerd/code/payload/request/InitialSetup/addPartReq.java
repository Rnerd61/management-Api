package com.rnerd.code.payload.request.InitialSetup;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class addPartReq {
    @NotBlank
    String productSkuId;

    @NotBlank
    String partSkuId;
}
