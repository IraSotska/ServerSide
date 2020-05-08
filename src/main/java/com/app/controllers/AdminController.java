package com.app.controllers;

import com.app.db.DBService;
import com.app.entities.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/adminpage")
public class AdminController extends HttpServlet {

    private DBService dbService = DBService.getDbServiceInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ArrayList<Customer> users = dbService.getAllUsersInfo();

        req.setAttribute("users", users);

        req.getRequestDispatcher("/WEB-INF/views/adminpage.jsp").forward(req, resp);

    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
//
//
//
//        }

}
