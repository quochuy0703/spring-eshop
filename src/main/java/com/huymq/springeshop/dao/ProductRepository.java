package com.huymq.springeshop.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.huymq.springeshop.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("from Product where newItem=true")
    public List<Product> findAllNewProduct();

    @Query("from Product where highlight=true")
    public List<Product> findAllHighlightProduct();

    @Query("Select p from Product p JOIN FETCH p.productProperty i where p.id =:id")
    public List<Product> findProductById(@Param("id") int theId);

    @Query("Select p from Product p where p.uuid =:uuid")
    public Product findProductByUUID(@Param("uuid") UUID uuid);

    @Query(value="Select p from Product p JOIN FETCH p.productProperty i where p.productType =:type", countQuery  = "Select count(p) from Product p  where p.productType =:type")
    public Page<Product> findProductByType(@Param("type") char type, Pageable pageable);

    @Query(value="Select p from Product p")
    public Page<Product> findAllProduct( Pageable pageable);

    List<Product> findTop3ByOrderByCountSaleDesc();
    List<Product> findTop3ByOrderByCountSeenDesc();

}
