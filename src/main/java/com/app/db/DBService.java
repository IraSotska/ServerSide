package com.app.db;

import com.app.entities.Customer;
import java.sql.*;
import java.util.ArrayList;

public class DBService {

    private static final String DB_URL = "jdbc:h2:/c:/JavaPrj/db/customerDB";
    private static final String DB_Driver = "org.h2.Driver";

    private static DBService dbService;

    private static Connection connection = null;

    private DBService() {
    }

    public static DBService getDbServiceInstance() {

        if (dbService==null) {

            dbService = new DBService();
            try {
                createTable();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dbService;
    }

    private static Connection getDBConnection () {

        try {

            if ((connection == null) || (connection.isClosed())) {

                try {
                    Class.forName(DB_Driver);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                connection = DriverManager.getConnection(DB_URL);
                connection.setTransactionIsolation(4);
                connection.setAutoCommit(false);
            }

        } catch (SQLException e) {
            System.out.println("Error creating connection");
            e.printStackTrace();
        }
        return connection;
    }

    private static void createTable() throws SQLException {

        try {

            Statement statement = getDBConnection().createStatement();

            statement.execute("create table IF NOT EXISTS users(" +
                    "firstName VARCHAR(20) NOT NULL, " +
                    "lastName VARCHAR(20) NOT NULL, " +
                    "email VARCHAR(20) NOT NULL PRIMARY KEY, " +
                    "password VARCHAR(20) NOT NULL, " +
                    "phone VARCHAR(13) NOT NULL, " +
                    "userRole VARCHAR(10) NOT NULL); ");

            connection.commit();
            System.out.println("Table creating sucsessfully!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback();

        } finally {

            if (connection != null) {
              //  connection.close();
            }
        }
    }

    public boolean checkPasswod(String emailo, String password) throws SQLException {

        boolean res = false;
        Connection connection = getDBConnection();
        connection.setAutoCommit(false);

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT password FROM users WHERE email=?;");
        preparedStatement.setString(1, emailo);

        ResultSet resultSet = preparedStatement.executeQuery();
        String correctPassword;

        while (resultSet.next()) {
            correctPassword = resultSet.getString("password");

            System.out.println("CORRECT PASS  " + correctPassword);
            if (correctPassword.equals(password)) {
                res = true;}
        }
        return res;
    }

    public void addCustomer(Customer customer) throws SQLException {

        try {

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (firstName, lastName, email, password, phone, userRole) VALUES (?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getSurName());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getPassword());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getUserRole());
            preparedStatement.executeUpdate();

            connection.commit();

            System.out.println("User added sucssesfully.");

        } catch (SQLException e) {
            System.out.println("Cant add customer to database.");
            connection.rollback();

        } finally {

            if (connection != null) {
               // connection.close();
            }
        }
    }

    public Customer getCustomerInfo(String email) {

        PreparedStatement preparedStatement;

        Customer customer = new Customer();
        customer.setEmail(email);

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE email=?;");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customer.setName(resultSet.getString("firstName"));
                customer.setSurName(resultSet.getString("lastName"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setUserRole(resultSet.getString("userRole"));
            }
        } catch (SQLException e) {
            System.out.println("Cant load user data.");
        }
       return customer;
    }

    public ArrayList<Customer> getAllUsersInfo() {

        ArrayList<Customer> customers = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {

                Customer customer = new Customer();

                customer.setName(resultSet.getString("firstName"));
                customer.setSurName(resultSet.getString("lastName"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setEmail(resultSet.getString("email"));
                customer.setPassword(resultSet.getString("password"));
                customer.setUserRole(resultSet.getString("userRole"));

                customers.add(customer);
            }

        } catch (SQLException e) {
            System.out.println("Cant read list of customers.");
        }

        return customers;
    }

}
