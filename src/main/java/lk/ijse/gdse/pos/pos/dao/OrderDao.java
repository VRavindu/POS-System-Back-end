package lk.ijse.gdse.pos.pos.dao;

import lk.ijse.gdse.pos.pos.dto.OrderDto;
import lk.ijse.gdse.pos.pos.entity.Order;

import java.sql.Connection;

public interface OrderDao extends SuperDao{
    String saveOrder(Order order, Connection connection);
}
