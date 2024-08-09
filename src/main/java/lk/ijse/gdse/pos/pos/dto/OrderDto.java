package lk.ijse.gdse.pos.pos.dto;

import lk.ijse.gdse.pos.pos.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class OrderDto {
    private String orderID;
    private String customerId;
    private int total;

    public static OrderDto toDto(Order order){
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderID(order.getOrderID());
        orderDto.setCustomerId(order.getCustomerId());
        orderDto.setTotal(order.getTotal());
        return orderDto;
    }
}
