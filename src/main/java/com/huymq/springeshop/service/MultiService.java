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
import com.huymq.springeshop.entity.ProductJsonInterface;
import com.huymq.springeshop.entity.Role;
import com.huymq.springeshop.entity.UserLogin;

public interface MultiService {
    public List<Product> findAllProduct();
    public List<Product> findAllNewProduct(boolean isNew);
    public List<Product> findAllHighlightProduct(boolean highlight);
    public List<Product> findAllBannerProduct(boolean isBanner);
    public Page<Product> findProductByType(char type, Pageable pageable);
    public Page<Product> findAllProduct(Pageable pageable);
    public Product findProductByUUID(UUID uuid);
    List<Product> findProductsTop3ByOrderByCountSaleDesc();
    List<Product> findProductsTop3ByOrderByCountSeenDesc();
    List<Product> findProductByNewItemOrHighlightOrIsBanner(boolean isNew, boolean highlight, boolean isBanner);
    List<ProductJsonInterface>  findProductJsonByBrand( int theId);
    List<ProductJsonInterface> findProductJsonByWord(String word);

    int countProductByNewItem(boolean isNew);
    int countProductByHighlight(boolean highlight);
    int countProductByIsBanner(boolean isBanner);
    List<Product> findProductByPriceBetween(double minPrice, double maxPrice);
    List<Product> findProductByProductTypeAndPriceBetween(char type,double minPrice, double maxPrice);
    List<ProductJsonInterface> findProductJsonByProductTypeAndPriceBetween(char type,double minPrice, double maxPrice);
    List<ProductJsonInterface> findProductJsonByProductTypeAndPriceGreaterThan(char type,double minPrice);

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

    //Role
    public Role findRoleByName(String name);

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
