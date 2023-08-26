package com.rnerd.code.config.services;

import com.rnerd.code.models.UserModel;
import com.rnerd.code.repository.AuthRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class UserDetailsServicesImpl implements UserDetailsService {

    private final AuthRepo authRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = authRepo.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("User Not Found");
        }else{
            return UserDetailsImpl.build(user);
        }
    }
}
