package com.huymq.springeshop.service;

import java.util.List;

import com.huymq.springeshop.entity.Customer;
import com.huymq.springeshop.entity.Product;

public interface MultiService {
    public List<Product> findAllProduct();
    public List<Product> findAllNewProduct();
    public List<Product> findAllHighlightProduct();
    public Product findProductById(int theId);
    public void saveProduct(Product product);

    //Customer
    public Customer findCustomerById(int theId);
    public void saveCustomer(Customer theCustomer);
}
