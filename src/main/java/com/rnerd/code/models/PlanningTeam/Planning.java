package com.rnerd.code.models.PlanningTeam;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@Data
@Document(collection = "planning")
public class Planning {
    @Id
    ObjectId id;

    @NotBlank
    private String taskName;

    @NotBlank @Size(min = 5)
    private String description;

    @NotBlank
    private String assignedTo;

    @Builder.Default
    private boolean isCompleted = false;

    @DBRef
    private List<PlanningReq> PlanningReqs;
}