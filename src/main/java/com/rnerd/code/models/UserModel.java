package com.rnerd.code.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;


@Document(collection = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
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

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserModel(String username, String password, String email, Roles role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}
