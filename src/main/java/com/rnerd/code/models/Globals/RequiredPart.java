package com.rnerd.code.models.Globals;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AvailableParts")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequiredPart {

    @Id
    private ObjectId id;

    @DBRef
    private SpareParts spareParts;

    @NotNull
    private Integer quantity;

    @NotBlank
    private Status CurrentStatus;





    public RequiredPart(SpareParts spareParts, Integer quantity) {
        this.spareParts = spareParts;
        this.quantity = quantity;
        this.CurrentStatus = Status.____;
    }


}
