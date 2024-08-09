package lk.ijse.gdse.pos.pos.bo;

import lk.ijse.gdse.pos.pos.dao.CustomerDao;
import lk.ijse.gdse.pos.pos.dao.CustomerDaoImpl;
import lk.ijse.gdse.pos.pos.dao.DaoFactory;
import lk.ijse.gdse.pos.pos.dto.CustomerDto;
import lk.ijse.gdse.pos.pos.entity.Customer;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class CustomerBoImpl implements CustomerBo{

    CustomerDao customerDao = (CustomerDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.CUSTOMER);

    @Override
    public boolean saveCustomer(CustomerDto customerDto, Connection connection) {
        return customerDao.saveCustomer(new Customer().toEntity(customerDto), connection);
    }

    @Override
    public CustomerDto getCustomer(String customerId, Connection connection) {
        return CustomerDto.toDto(customerDao.getCustomer(customerId, connection));
    }

    @Override
    public boolean updateCustomer(String customerId, CustomerDto customerDto, Connection connection) {
        return customerDao.updateCustomer(customerId, Customer.toEntity(customerDto), connection);
    }

    @Override
    public boolean deleteCustomer(String customerId, Connection connection) {
        return customerDao.deleteCustomer(customerId, connection);
    }

    @Override
    public List<CustomerDto> getAllCustomers(Connection connection) {
        List<Customer> customers = customerDao.getAllCustomers(connection);
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (int i=0; i<customers.toArray().length; i++){
            customerDtos.add(CustomerDto.toDto(customers.get(i)));
        }
        return customerDtos;
    }
}
