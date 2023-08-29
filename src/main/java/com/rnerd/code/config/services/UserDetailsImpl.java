package com.rnerd.code.config.services;

import com.rnerd.code.models.Globals.EmployeeModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;


@Setter
@Getter
@EqualsAndHashCode
public class UserDetailsImpl implements UserDetails {

    private ObjectId id;

    private String username;

    private String email;

    private String password;

    private String employeeAt;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(ObjectId id, String username, String email, String password, String employeeAt,Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.employeeAt = employeeAt;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(EmployeeModel user) {
        Collection<? extends GrantedAuthority> authorities =  Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name()));

        return new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getEmployeeAt(),
                authorities);
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
