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
    @Id
    private ObjectId id;

    @Indexed(unique = true)
    @NotBlank @Size(min = 3, max = 15)
    private String username;

    @NotBlank @Size(min = 8, max = 100)
    private String password;

    @NotBlank @Email
    private String email;

    @NotBlank
    private Roles role;

    public EmployeeModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public EmployeeModel(String username, String password, String email, Roles role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}
