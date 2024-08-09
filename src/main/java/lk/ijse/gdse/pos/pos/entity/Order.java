package lk.ijse.gdse.pos.pos.entity;

import lk.ijse.gdse.pos.pos.dto.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Order {
    private String orderID;
    private String customerId;
//    private Date date;
//    private double subTotal;
    private int total;

    public static Order toEntity(OrderDto orderDto){
        Order order = new Order();
        order.setOrderID(orderDto.getOrderID());
        order.setCustomerId(orderDto.getCustomerId());
        order.setTotal(orderDto.getTotal());
//        order.setDate(orderDto.getDate());
//        order.setSubTotal(orderDto.getSubTotal());
        return order;
    }
}
