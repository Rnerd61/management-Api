package com.rnerd.code.models.PlanningTeam;


import com.rnerd.code.models.ServiceTeam.AvailableParts;
import com.rnerd.code.models.ServiceTeam.ServiceCenter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "planningReq")
public class PlanningReq {
    @Id
    ObjectId id;

    @NotBlank
    private ServiceCenter from;

    @NotBlank @Size(min = 5)
    private String description;

    @DateTimeFormat
    private Date dueDate;

    @DBRef
    private List<AvailableParts> RequiredParts;

}