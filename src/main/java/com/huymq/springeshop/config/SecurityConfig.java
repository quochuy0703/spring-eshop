package com.huymq.springeshop.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.huymq.springeshop.entity.UserLogin;
import com.huymq.springeshop.service.CustomUserDetail;
import com.huymq.springeshop.service.CustomUserDetailImpl;

@Configuration
public class SecurityConfig {

    @Bean
    public CustomUserDetailImpl customUserDetailImpl(){
        return new CustomUserDetailImpl();
    }

    @Bean 
    public PasswordEncoder PasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    SecurityFilterChain FilterChain(HttpSecurity http) throws Exception{
        http.csrf().disable();
        http.authorizeRequests()
        .antMatchers("/cart/**","/account/**").authenticated()
        .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
        .anyRequest().permitAll()
        .and().formLogin().usernameParameter("email").passwordParameter("password").permitAll()
        .and().logout().permitAll();

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/css/**","/webjars/**","/uploads/**");
    }
}
