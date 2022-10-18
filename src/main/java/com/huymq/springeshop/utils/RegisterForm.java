package com.huymq.springeshop.utils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.huymq.springeshop.entity.Customer;


public class RegisterForm {

    @NotEmpty(message = "First Name cannot be empty.")
    @Size(min=2, max=30, message = "First Name should 2-30 character") 
    private String firstName;

    @NotEmpty(message = "Last Name cannot be empty.")
    private String lastName;

    @NotEmpty(message = "Email cannot be empty.")
    private String email;

    
    private String phone;

    @NotEmpty(message = "Password cannot be empty.")
    private String password;

    @NotEmpty(message = "Confirm Password cannot be empty.")
    private String confirmPassword;
    
    public RegisterForm() {
    }

    public Customer getCustomer(){
        Customer theCustomer = new Customer();

        theCustomer.setEmail(this.email);
        theCustomer.setLastName(this.lastName);
        theCustomer.setFirstName(this.firstName);
        theCustomer.setPhone(this.phone);

        return theCustomer;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    

}
