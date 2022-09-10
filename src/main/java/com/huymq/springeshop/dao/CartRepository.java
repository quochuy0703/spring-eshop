package com.huymq.springeshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huymq.springeshop.entity.Cart;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    
}
