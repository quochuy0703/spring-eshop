package com.huymq.springeshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.huymq.springeshop.entity.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, Integer> {
    @Query("select u from UserLogin u where u.email=?1")
    public UserLogin findUserLoginByEmail(String email);
}
