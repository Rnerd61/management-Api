package com.rnerd.code.models.PlanningTeam;


import com.rnerd.code.models.Globals.RequiredPart;
import com.rnerd.code.models.Globals.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "planningReq")
public class PlanningReq {
    @Id
    ObjectId id;

    @NotBlank
    private String from;

    @NotBlank @Size(min = 5)
    private String description;

    @DateTimeFormat
    private LocalDateTime CreatedAt;

    @DBRef
    private List<RequiredPart> RequiredParts = new ArrayList<>();


    public PlanningReq(String serviceCenter, String description, RequiredPart requestedParts) {
        this.from = serviceCenter;
        this.description = description;
        this.CreatedAt = java.time.LocalDateTime.now();
        this.RequiredParts.add(requestedParts);
        this.RequiredParts.forEach(requiredPart -> requiredPart.setCurrentStatus(Status.INPROGRESS));
    }
}