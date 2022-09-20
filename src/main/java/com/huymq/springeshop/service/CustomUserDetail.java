package com.huymq.springeshop.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.huymq.springeshop.entity.Role;
import com.huymq.springeshop.entity.UserLogin;

public class CustomUserDetail implements UserDetails {

    private UserLogin userLogin;

    CustomUserDetail(UserLogin userLogin){
        this.userLogin = userLogin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> theRoles = userLogin.getRoles();

        List<SimpleGrantedAuthority> list = new ArrayList<>();

        for(Role role : theRoles){
            list.add(new SimpleGrantedAuthority(role.getName()));
        }

        System.out.println(list);
 
        return list;
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
