package com.rnerd.code.payload.request;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;

@Getter
@Setter
public class CustomerReq {

    String customerName;
    String productId;

    @Email
    String email;
}
