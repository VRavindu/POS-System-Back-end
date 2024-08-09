package lk.ijse.gdse.pos.pos.bo;

import lk.ijse.gdse.pos.pos.dto.CustomerDto;

import java.sql.Connection;
import java.util.List;

public interface CustomerBo extends SuperBo{
    boolean saveCustomer(CustomerDto customerDto, Connection connection);
    CustomerDto getCustomer(String customerId, Connection connection);
    boolean updateCustomer(String customerId, CustomerDto customerDto, Connection connection);
    boolean deleteCustomer(String customerId, Connection connection);
    List<CustomerDto> getAllCustomers(Connection connection);
}
