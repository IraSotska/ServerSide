package com.app.controllers;

import com.app.db.DBService;
import com.app.entities.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/signin")

public class SignInController extends HttpServlet {

    private String password;
    private String email;
    private String surname;
    private String phone;
    private String name;

    private DBService dbService = DBService.getDbServiceInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        password = request.getParameter("password");
        email = request.getParameter("email");
        surname = request.getParameter("surname");
        phone = request.getParameter("phone");
        name = request.getParameter("name");

        Customer customer = new Customer(name, surname, password, email, phone);

        try {
            dbService.addCustomer(customer);
        } catch (SQLException e) {
            System.out.println("Error adding customer to database.");
        }

        System.out.println("PASSWORD " + password + " " + "EMAIL " + email + " " + "Surname " + surname + " " + "NAME " + name
                + " " + "PHONE " + phone);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/views/signinpage.jsp").forward(req, resp);
    }
}

