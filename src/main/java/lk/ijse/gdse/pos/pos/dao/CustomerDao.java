package lk.ijse.gdse.pos.pos.dao;

import lk.ijse.gdse.pos.pos.dto.CustomerDto;
import lk.ijse.gdse.pos.pos.entity.Customer;

import java.sql.Connection;
import java.util.List;

public interface CustomerDao extends SuperDao{
    boolean saveCustomer(Customer customer, Connection connection);
    Customer getCustomer(String customerId, Connection connection);
    boolean updateCustomer(String customerId, Customer customer, Connection connection);
    boolean deleteCustomer(String customerId, Connection connection);
    List<Customer> getAllCustomers(Connection connection);
}
