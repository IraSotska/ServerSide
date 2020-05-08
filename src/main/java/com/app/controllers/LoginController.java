package com.app.controllers;

import com.app.db.DBService;
import com.app.entities.Customer;
import com.app.entities.UserAccount;
import com.app.utils.AppUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")

public class LoginController extends HttpServlet {

    private DBService dbService = DBService.getDbServiceInstance();

    private boolean checkPassword;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

//        Customer customer = new Customer("Ryba", "Sotska", "888", "ryba.com", "1313131313");
//        customer.setUserRole("admin");
//
//        try {
//            dbService.addCustomer(customer);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        String pass = request.getParameter("password");
        String email = request.getParameter("email");

        try {
            checkPassword = dbService.checkPasswod(email, pass);
            System.out.println("PASSWORD IS CORRECT  " + checkPassword);
          
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(checkPassword) {
            AppUtils.setUserAccount(request, email);
        }

        System.out.println("PASSWORD " + pass + "EMAIL " + email);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/views/loginpage.jsp").forward(req, resp);
    }
}
