package com.huymq.springeshop.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.huymq.springeshop.entity.Cart;
import com.huymq.springeshop.entity.Customer;
import com.huymq.springeshop.entity.Order;
import com.huymq.springeshop.entity.OrderItem;
import com.huymq.springeshop.entity.OrderStatus;
import com.huymq.springeshop.entity.Product;
import com.huymq.springeshop.entity.UserLogin;

public interface MultiService {
    public List<Product> findAllProduct();
    public List<Product> findAllNewProduct();
    public List<Product> findAllHighlightProduct();
    public Page<Product> findProductByType(char type, Pageable pageable);
    public Page<Product> findAllProduct(Pageable pageable);
    public Product findProductByUUID(UUID uuid);
    List<Product> findProductsTop3ByOrderByCountSaleDesc();
    List<Product> findProductsTop3ByOrderByCountSeenDesc();

    // public int getCountByProductType(char type);
    public Product findProductById(int theId);
    public void saveProduct(Product product);

    //Customer
    public Customer findCustomerById(int theId);
    public Customer findCustomerByEmail(String email);
    public void saveCustomer(Customer theCustomer);

    //UserLogin
    public UserLogin findUserLoginById(int theId);
    public UserLogin findUserLoginByEmail(String email);
    public void saveUserLogin(UserLogin UserLogin);

    //cart
    public Cart findCartById(int theId);
    public void deleteCartById(int theId);
    public void saveCart(Cart theCart);


    //order
    public void saveOrder(Order theOrder);
    public int countOrder();

    //orderItem
    public void saveOrderItem(OrderItem theOrderItem);
    public OrderItem findOrderItemById(int theId);
    public Page<OrderItem> findOrderItemByStatus( OrderStatus status, Pageable pageable);
}
