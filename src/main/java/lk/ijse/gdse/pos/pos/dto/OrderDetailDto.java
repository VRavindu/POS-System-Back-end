package lk.ijse.gdse.pos.pos.dto;

import lk.ijse.gdse.pos.pos.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetailDto {
    private String orderId;
    private String itemCode;
    private  double unitPrice;
    private int qty;

    public static OrderDetailDto toDto(OrderDetail orderDetail){
        OrderDetailDto orderDetailDto = new OrderDetailDto();
        orderDetailDto.setOrderId(orderDetail.getOrderId());
        orderDetailDto.setItemCode(orderDetail.getItemCode());
        orderDetailDto.setUnitPrice(orderDetail.getUnitPrice());
        orderDetailDto.setQty(orderDetailDto.getQty());
        return orderDetailDto;
    }
}
