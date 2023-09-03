package com.rnerd.code.payload.request.SC.Customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;

@Getter
@Setter
public class CustomerReq {

    @NotBlank
    String customerName;
    @NotBlank
    String productId;

    @Email
    String email;
}
