package com.rnerd.code.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerReq {
    String customerName;
    String productId;
    String email;
}
