package com.test.mongo.mongotest.servicio;

import com.test.mongo.mongotest.model.User;
import com.test.mongo.mongotest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailServiceAuth implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User userFound = userRepository.findByEmail(email);
        return new org.springframework.security.core.userdetails.User(userFound.getEmail()
                , "{noop}"+userFound.getPassword(), new ArrayList<>());
    }
}
