package com.app.controllers;

import com.app.db.DBService;
import com.app.entities.UserAccount;

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

    private UserAccount userAccount = new UserAccount();
    private boolean checkPassword;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        String pass = request.getParameter("password");
        String email = request.getParameter("email");

        HttpSession session = request.getSession();

        try {
            checkPassword = dbService.checkPasswod(email, pass);
            System.out.println("PASSWORD IS CORRECT  " + checkPassword);
          
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(checkPassword) {
            userAccount.setCustomer(dbService.getCustomerInfo(email));
            session.setAttribute("loginedUser", userAccount);
        }

        System.out.println("PASSWORD " + pass + "EMAIL " + email);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/views/loginpage.jsp").forward(req, resp);
    }
}
