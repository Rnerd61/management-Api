package com.rnerd.code.payload.response;

import com.rnerd.code.config.services.UserDetailsImpl;

import java.util.HashMap;
import java.util.Map;

public class ResponseUserDetails {

    public final String username;
    public final String email;
    public final String role;

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
