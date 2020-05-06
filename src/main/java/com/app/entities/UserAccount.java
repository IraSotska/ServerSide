package com.app.entities;

public class UserAccount {

    private UserOrders userOrders;
    private Customer customer;

    public UserAccount() {
    }

    public UserAccount(UserOrders userOrders, Customer customer) {
        this.userOrders = userOrders;
        this.customer = customer;
    }

    public UserOrders getUserOrders() {
        return userOrders;
    }

    public void setUserOrders(UserOrders userOrders) {
        this.userOrders = userOrders;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
