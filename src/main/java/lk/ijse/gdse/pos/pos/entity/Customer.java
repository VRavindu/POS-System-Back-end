package lk.ijse.gdse.pos.pos.entity;

import lk.ijse.gdse.pos.pos.dto.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Customer {
    private String id;
    private String name;
    private String address;
    private String salary;

    public static Customer toEntity(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setName(customerDto.getName());
        customer.setAddress(customerDto.getAddress());
        customer.setSalary(customerDto.getSalary());
        return customer;
    }

}
