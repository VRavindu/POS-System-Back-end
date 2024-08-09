package lk.ijse.gdse.pos.pos.dao;

import lk.ijse.gdse.pos.pos.dto.CustomerDto;
import lk.ijse.gdse.pos.pos.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao{
    public static String SAVE_CUSTOMER = "Insert into customer values (?,?,?,?)";
    public static String GET_CUSTOMER = "Select * from customer where id = ?";
    public static String UPDATE_CUSTOMER = "Update customer SET name=?, address=?, salary=? WHERE id=?";
    public static String DELETE_CUSTOMER = "Delete from customer where id = ?";
    public static String GET_ALL = "Select * from customer";

    @Override
    public boolean saveCustomer(Customer customer, Connection connection) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SAVE_CUSTOMER);
            preparedStatement.setString(1, customer.getId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.setString(4, customer.getSalary());

            if (preparedStatement.executeUpdate() != 0){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Customer getCustomer(String customerId, Connection connection) {
        var customer = new Customer();
        try {
            var ps = connection.prepareStatement(GET_CUSTOMER);
            ps.setString(1, customerId);
            var rst = ps.executeQuery();
            while (rst.next()){
                customer.setId(rst.getString("id"));
                customer.setName(rst.getString("name"));
                customer.setAddress(rst.getString("address"));
                customer.setSalary(rst.getString("salary"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    @Override
    public boolean updateCustomer(String customerId, Customer customer, Connection connection) {
        try{
            var ps = connection.prepareStatement(UPDATE_CUSTOMER);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getAddress());
            ps.setString(3, customer.getSalary());
            ps.setString(4, customerId);
            return ps.executeUpdate() != 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteCustomer(String customerId, Connection connection){
        try{
            var ps = connection.prepareStatement(DELETE_CUSTOMER);
            ps.setString(1, customerId);
            return  ps.executeUpdate() != 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Customer> getAllCustomers(Connection connection) {
        List <Customer> customers = new ArrayList<>();
        try{
            var ps = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Customer customer = new Customer();
                customer.setId(resultSet.getString("id"));
                customer.setName(resultSet.getString("name"));
                customer.setAddress(resultSet.getString("address"));
                customer.setSalary(resultSet.getString("salary"));
                customers.add(customer);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return customers;
    }
}
