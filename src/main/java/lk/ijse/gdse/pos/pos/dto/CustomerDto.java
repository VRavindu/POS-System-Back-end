package lk.ijse.gdse.pos.pos.dto;

import lk.ijse.gdse.pos.pos.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerDto {
    private String id;
    private String name;
    private String address;
    private String salary;

    public static CustomerDto toDto(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setAddress(customer.getAddress());
        customerDto.setSalary(customer.getSalary());
        return customerDto;
    }
}
