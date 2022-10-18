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


   

    @Query("Select p from Product p JOIN FETCH p.productProperty i where p.id =:id")
    public List<Product> findProductById(@Param("id") int theId);

    @Query("Select p from Product p where p.uuid =:uuid")
    public Product findProductByUUID(@Param("uuid") UUID uuid);

    @Query(value="Select p from Product p JOIN FETCH p.brand JOIN FETCH p.productProperty where p.productType =:type", countQuery  = "Select count(p) from Product p  where p.productType =:type")
    public Page<Product> findProductByType(@Param("type") char type, Pageable pageable);

    @Query(value="Select p from Product p")
    public Page<Product> findAllProduct( Pageable pageable);

    List<Product> findTop3ByOrderByCountSaleDesc();
    List<Product> findTop3ByOrderByCountSeenDesc();
    List<Product> findByNewItem(boolean isNew);
    List<Product> findByHighlight(boolean highlight);
    List<Product> findByIsBanner(boolean banner);
    List<Product> findByNewItemOrHighlightOrIsBanner(boolean isNew, boolean highlight,boolean banner);
    List<Product> findByNameContaining(String name);
    List<Product> findByPriceBetween(double minPrice, double maxPrice);
    <T> List<T> findByProductTypeAndPriceBetween(Class<T> classType,char type,double minPrice, double maxPrice);
    <T> List<T> findByProductTypeAndPriceGreaterThan(Class<T> classType,char type,double minPrice);
    
    @Query("select p from Product p JOIN FETCH p.brand where p.brand.id =:id")
    <T> List<T> findByBrand(Class<T> classType,@Param("id") int theId);

    @Query("select p from Product p JOIN FETCH p.brand where CONCAT(p.name, p.brand.name, p.price) LIKE %:word%")
    <T> List<T> findByWord(Class<T> classType,@Param("word") String word);

    int countByNewItem(boolean isNew);
    int countByHighlight(boolean highlight);
    int countByIsBanner(boolean isBanner);
}
