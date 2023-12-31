package com.rnerd.code.models.Globals;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {
//    @Id
//    private ObjectId id;

    @Id
    @Indexed(unique = true)
    @NotBlank @Size(min = 3, max = 15)
    private String username;

    @NotBlank @Size(min = 8, max = 100)
    private String password;

    @NotBlank @Email
    private String email;

    @NotBlank
    private Roles role;

    @NotBlank
    private String EmployeeAt;

}
