package com.rnerd.code.payload.response;

import com.rnerd.code.config.services.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;
import java.util.Map;

public class ResponseUserDetails {

    public String username;
    public String email;
    public String role;

    public ResponseUserDetails(UserDetailsImpl user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.role = user.getAuthorities().toString();
    }

    public Map<String, String> getDetails(){
        Map<String, String> res = new HashMap<>();
        res.put("username", this.username);
        res.put("email", this.email);
        res.put("role", this.role);

        return res;
    }
}
