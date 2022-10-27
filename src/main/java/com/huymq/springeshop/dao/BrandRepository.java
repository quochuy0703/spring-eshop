package com.huymq.springeshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huymq.springeshop.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    
    List<Brand> findByType(String type);
    Brand findByNameAndType(String name,String type);
 }
