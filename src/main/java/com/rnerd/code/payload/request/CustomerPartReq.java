package com.rnerd.code.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class CustomerPartReq {
    String CustomerName;
    String skuid;
}
