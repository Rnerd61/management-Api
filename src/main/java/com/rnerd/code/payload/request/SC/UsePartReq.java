package com.rnerd.code.payload.request.SC;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UsePartReq {
    @NotBlank
    String skuid;

    @NotBlank
    Integer quantity;
}
