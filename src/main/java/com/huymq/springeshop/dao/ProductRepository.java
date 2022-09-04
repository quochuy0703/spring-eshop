package com.huymq.springeshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.huymq.springeshop.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("from Product where newItem=true")
    public List<Product> findAllNewProduct();

    @Query("from Product where highlight=true")
    public List<Product> findAllHighlightProduct();
}
