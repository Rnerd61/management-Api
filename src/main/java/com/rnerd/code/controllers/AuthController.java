package com.rnerd.code.controllers;

import com.rnerd.code.payload.request.LoginRequest;
import com.rnerd.code.payload.request.RegisterRequest;
import com.rnerd.code.payload.request.ResponseMsg;
import com.rnerd.code.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(value = "http://localhost:3000", maxAge = 3000)
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@Valid @RequestBody RegisterRequest request) {
        return authService.register(request.getUsername(), request.getPassword(), request.getEmail(), request.getRole());
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Map<String, String> res = ResponseMsg.Msg(List.of("msg", "success"),List.of(authService.login(loginRequest), "1"));
        return ResponseEntity.ok().body(res);
    }


}
