//package com.app.utils;
//
//import com.app.entities.Customer;
//import com.app.entities.UserAccount;
//
//import javax.servlet.http.HttpSession;
//
//public class AppUtils {
//
//    private Customer currentCustomer;
//
//    public Customer getCurrentCustomer() {
//        return currentCustomer;
//    }
//
//    public void setCurrentCustomer(Customer currentCustomer) {
//        this.currentCustomer = currentCustomer;
//    }
//
//    public static UserAccount getLoginedUser(HttpSession session) {
//        UserAccount loginedUser = (UserAccount) session.getAttribute("loginedUser");
//        return loginedUser;
//    }
//
//}
