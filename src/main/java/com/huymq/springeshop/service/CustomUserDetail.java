package com.huymq.springeshop.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.huymq.springeshop.entity.UserLogin;

public class CustomUserDetail implements UserDetails {

    private UserLogin userLogin;

    CustomUserDetail(UserLogin userLogin){
        this.userLogin = userLogin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getPassword() {

        return userLogin.getPassword();
    }

    @Override
    public String getUsername() {

        return userLogin.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
   
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
      
        return true;
    }

    @Override
    public boolean isEnabled() {
        
        return true;
    }
    
}
