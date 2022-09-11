package com.huymq.springeshop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.huymq.springeshop.entity.Cart;
import com.huymq.springeshop.entity.Customer;
import com.huymq.springeshop.entity.Order;
import com.huymq.springeshop.entity.OrderItem;
import com.huymq.springeshop.entity.Product;

public interface MultiService {
    public List<Product> findAllProduct();
    public List<Product> findAllNewProduct();
    public List<Product> findAllHighlightProduct();
    public Page<Product> findProductByType(char type, Pageable pageable);

    // public int getCountByProductType(char type);
    public Product findProductById(int theId);
    public void saveProduct(Product product);

    //Customer
    public Customer findCustomerById(int theId);
    public void saveCustomer(Customer theCustomer);

    //cart
    public Cart findCartById(int theId);
    public void deleteCartById(int theId);
    public void saveCart(Cart theCart);


    //order
    public void saveOrder(Order theOrder);

    //orderItem
    public void saveOrderItem(OrderItem theOrderItem);
}
