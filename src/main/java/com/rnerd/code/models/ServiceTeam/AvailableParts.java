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
    private ObjectId id;

    @DBRef
    private SpareParts spareParts;

    @NotNull
    private Integer quantity;


    public AvailableParts(SpareParts spareParts, Integer quantity) {
        this.spareParts = spareParts;
        this.quantity = quantity;
    }
}
