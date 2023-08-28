package com.rnerd.code.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerReq {
    String customerName;
    String productId;
    String email;
}
