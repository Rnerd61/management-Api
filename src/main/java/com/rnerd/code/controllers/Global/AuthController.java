package com.rnerd.code.controllers.Global;

import com.rnerd.code.config.jwt.JwtUtils;
import com.rnerd.code.config.services.UserDetailsImpl;
import com.rnerd.code.config.services.UserDetailsServicesImpl;
import com.rnerd.code.payload.request.LoginRequest;
import com.rnerd.code.payload.request.RegisterRequest;
import com.rnerd.code.payload.response.ResponseMsg;
import com.rnerd.code.payload.response.ResponseUserDetails;
import com.rnerd.code.services.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
    private final JwtUtils jwtUtils;
    private final UserDetailsServicesImpl userDetailsService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@Valid @RequestBody RegisterRequest request) {
        return authService.register(request.getUsername(), request.getPassword(), request.getEmail(), request.getRole());
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Map<String, String> res = ResponseMsg.Msg(List.of("msg", "success"),List.of(authService.login(loginRequest), "1"));
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/user")
    public ResponseEntity<Map<String, String>> getUser(HttpServletRequest request, HttpServletResponse response){
        String username = jwtUtils.getUserNameFromJwtToken(jwtUtils.getJwtFromCookies(request));
        UserDetailsImpl user = userDetailsService.loadUserByUsername(username);

        ResponseUserDetails res = new ResponseUserDetails(user);

        return ResponseEntity.ok().body(res.getDetails());
    }


}
