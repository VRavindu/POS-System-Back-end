package lk.ijse.gdse.pos.pos.entity;

import lk.ijse.gdse.pos.pos.dto.OrderDetailDto;
import lk.ijse.gdse.pos.pos.dto.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class OrderDetail {
    private String orderId;
    private String itemCode;
    private  double unitPrice;
    private int qty;

    public static OrderDetail toEntity(OrderDetailDto orderDetailDto){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(orderDetailDto.getOrderId());
        orderDetail.setItemCode(orderDetailDto.getItemCode());
        orderDetail.setUnitPrice(orderDetailDto.getUnitPrice());
        orderDetail.setQty(orderDetailDto.getQty());
        return orderDetail;
    }
}


