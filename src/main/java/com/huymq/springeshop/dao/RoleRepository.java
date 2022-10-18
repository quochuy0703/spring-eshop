package com.huymq.springeshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huymq.springeshop.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    public Role findByName(String name);
}
