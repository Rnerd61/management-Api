package com.rnerd.code.payload.request.PT;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetAllPlanningTasksReq {
    @NotBlank
    Integer pageNumber;
}
