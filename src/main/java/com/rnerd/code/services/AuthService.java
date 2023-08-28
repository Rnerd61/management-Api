package com.rnerd.code.services;

import com.rnerd.code.config.jwt.JwtUtils;
import com.rnerd.code.config.services.UserDetailsImpl;
import com.rnerd.code.models.Globals.Roles;
import com.rnerd.code.models.Globals.EmployeeModel;
import com.rnerd.code.payload.request.LoginRequest;
import com.rnerd.code.payload.response.ResponseMsg;
import com.rnerd.code.repository.Global.AuthRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service @RequiredArgsConstructor
public class AuthService {

    private final AuthRepo authRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public ResponseEntity<Map<String, String>> register(String username, String password, String email, String role) {

        if ((authRepo.findByUsername(username) != null) || (authRepo.findByEmail(email) != null) )
            return new ResponseEntity<>(ResponseMsg.Msg( "User Already Exists"), HttpStatus.FORBIDDEN);

        String _password = passwordEncoder.encode(password);
        Roles roles;

        try {
            roles = Roles.valueOf(role);
        } catch (Exception e) {
            return new ResponseEntity<>(ResponseMsg.Msg("User Not Found"), HttpStatus.BAD_REQUEST);
        }

        authRepo.insert(new EmployeeModel(username, _password, email, roles));
        return new ResponseEntity<>(ResponseMsg.Msg("User Registered SuccessFully"), HttpStatus.OK);
    }


    public String login(LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return jwtUtils.generateJwtCookie(userDetails).toString();
    }

}
