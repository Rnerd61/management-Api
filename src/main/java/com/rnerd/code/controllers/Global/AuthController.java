package com.rnerd.code.controllers.Global;

import com.rnerd.code.config.jwt.JwtUtils;
import com.rnerd.code.config.services.UserDetailsImpl;
import com.rnerd.code.config.services.UserDetailsServicesImpl;
import com.rnerd.code.payload.request.Auth.LoginRequest;
import com.rnerd.code.payload.request.Auth.RegisterRequest;
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
@CrossOrigin(origins = "http://172.31.52.191:3000", maxAge = 3000, allowCredentials = "true")
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;
    private final JwtUtils jwtUtils;
    private final UserDetailsServicesImpl userDetailsService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@Valid @RequestBody RegisterRequest request) {
        return authService.register(request.getUsername(), request.getPassword(), request.getEmail(), request.getRole(), request.getEmployeeAt());
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Map<String, String> res = ResponseMsg.Msg(List.of("msg", "success"),List.of(authService.login(loginRequest), "1"));
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/user")
    public ResponseEntity<Map<String, String>> getUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            String username = jwtUtils.getUserNameFromJwtToken(jwtUtils.getJwtFromCookies(request));

            UserDetailsImpl user = userDetailsService.loadUserByUsername(username);

            ResponseUserDetails res = new ResponseUserDetails(user);

            return ResponseEntity.ok().body(res.getDetails());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(ResponseMsg.Msg(e.getMessage()));
        }

    }


}
