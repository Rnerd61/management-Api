package com.rnerd.code.config.services;

import com.rnerd.code.models.Globals.EmployeeModel;
import com.rnerd.code.repository.AuthRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServicesImpl implements UserDetailsService {

    private final AuthRepo authRepo;
    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        EmployeeModel user = authRepo.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("User Not Found");
        }else{
            return UserDetailsImpl.build(user);
        }
    }
}
