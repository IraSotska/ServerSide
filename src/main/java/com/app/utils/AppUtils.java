package com.app.utils;

import com.app.db.DBService;
import com.app.entities.Customer;
import com.app.entities.UserAccount;
import com.sun.deploy.net.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AppUtils {

    private static UserAccount userAccount = new UserAccount();
    private static DBService dbService = DBService.getDbServiceInstance();

    public static void setUserAccount(HttpServletRequest request, String email) {

        HttpSession session = request.getSession();

        userAccount.setCustomer(dbService.getCustomerInfo(email));
        session.setAttribute("loginedUser", userAccount);

    }

    public static UserAccount getLoginedUser(HttpSession session) {
        UserAccount loginedUser = (UserAccount) session.getAttribute("loginedUser");
        return loginedUser;
    }

}
