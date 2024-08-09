package lk.ijse.gdse.pos.pos.bo;

import lk.ijse.gdse.pos.pos.dto.OrderDto;

import java.sql.Connection;

public interface OrderBo extends SuperBo{
    String saveOrder(OrderDto orderDto, Connection connection);
}
