package lk.ijse.gdse.pos.pos.dao;

import lk.ijse.gdse.pos.pos.dto.OrderDetailDto;
import lk.ijse.gdse.pos.pos.entity.OrderDetail;

import java.sql.Connection;

public interface OrderDetailDao extends SuperDao{
    String saveOrderDetail(OrderDetail orderDetail, Connection connection);
}
