package com.codegym.cms.service;

import com.codegym.cms.connection.ConnectionCMS;
import com.codegym.cms.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerService {
    private Connection connection = ConnectionCMS.getConnection();

    @Override
    public List<Customer> findAll() {
        //tao moi 1 arrray list
        List<Customer> customers = new ArrayList<>();
        //ket noi csdl
        try(
        PreparedStatement statement = connection.prepareStatement("select * from customer;");){
            //goi truy van
            ResultSet resultSet = statement.executeQuery();
            //khop du lieu o csdl vao arraylist
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                Customer customer = new Customer(id, name, email, address);
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Customer customer) {

    }

    @Override
    public void remove(int id) {

    }

    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.findAll();
    }
}
