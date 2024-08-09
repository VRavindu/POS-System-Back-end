package lk.ijse.gdse.pos.pos.dao;

import lk.ijse.gdse.pos.pos.dto.OrderDetailDto;
import lk.ijse.gdse.pos.pos.entity.OrderDetail;

import java.sql.Connection;
import java.sql.SQLException;

public class OrderDetailDaoImpl implements OrderDetailDao{
    public static String SAVE_ORDER_DETAIL = "insert into order_detail values (?,?,?,?)";
    @Override
    public String saveOrderDetail(OrderDetail orderDetail, Connection connection) {
        try {
            var ps = connection.prepareStatement(SAVE_ORDER_DETAIL);
            ps.setString(1, orderDetail.getOrderId());
            ps.setString(2, orderDetail.getItemCode());
            ps.setDouble(3, orderDetail.getUnitPrice());
            if (ps.executeUpdate() !=0 ){
                return "Order Details Saved Successfully";
            }else {
                return "Something went wrong";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
