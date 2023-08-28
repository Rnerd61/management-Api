package com.rnerd.code.models.ServiceTeam;

import com.rnerd.code.models.Globals.SpareParts;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AvailableParts")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AvailableParts {

    @Id
    ObjectId id;

    @NotNull
    Integer Quantity = 0;

    @DBRef
    SpareParts spareParts;
}
