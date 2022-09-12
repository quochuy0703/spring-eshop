package com.huymq.springeshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.huymq.springeshop.dao.UserLoginRepository;
import com.huymq.springeshop.entity.UserLogin;

public class CustomUserDetailImpl implements UserDetailsService {

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserLogin userLogin = userLoginRepository.findUserLoginByEmail(username);

        if(userLogin == null){
            throw new UsernameNotFoundException("User not found");
        }
        
        
        return new CustomUserDetail(userLogin);
    }
    
}
