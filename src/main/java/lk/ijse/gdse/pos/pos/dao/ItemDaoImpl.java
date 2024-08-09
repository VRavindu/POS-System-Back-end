package lk.ijse.gdse.pos.pos.dao;

import lk.ijse.gdse.pos.pos.dto.CustomerDto;
import lk.ijse.gdse.pos.pos.dto.ItemDto;
import lk.ijse.gdse.pos.pos.entity.Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao{
    public static String SAVE_ITEM = "insert into item values (?,?,?,?)";
    public static String GET_ITEM = "select * from item where item_code = ?";
    public static String UPDATE_ITEM = "update item set item_name = ?, item_qty = ?, unit_price = ? where item_code = ?";
    public static String DELETE_ITEM = "delete from item where item_code = ?";
    public static String GET_ALL = "select * from item";

    @Override
    public String saveItem(Item item, Connection connection) {
        try {
            var ps = connection.prepareStatement(SAVE_ITEM);
            ps.setString(1, item.getItemCode());
            ps.setString(2, item.getItemName());
            ps.setInt(3, item.getItemQty());
            ps.setDouble(4, item.getUnitPrice());
            if (ps.executeUpdate() !=0 ){
                return "Item Saved Successfully";
            }else {
                return "Something went wrong";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Item getItem(String itemCode, Connection connection) {
        Item item = new Item();
        try{
            var ps = connection.prepareStatement(GET_ITEM);
            ps.setString(1, itemCode);
            var rst = ps.executeQuery();
            while (rst.next()){
                item.setItemCode(rst.getString("item_code"));
                item.setItemName(rst.getString("item_name"));
                item.setItemQty(rst.getInt("item_qty"));
                item.setUnitPrice(rst.getDouble("unit_price"));
            }
            return item;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Item> getAllItems(Connection connection) {
        List<Item> items = new ArrayList<>();
        try {
            var ps = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Item item = new Item();
                item.setItemCode(resultSet.getString("item_code"));
                item.setItemName(resultSet.getString("item_name"));
                item.setItemQty(resultSet.getInt("item_qty"));
                item.setUnitPrice(resultSet.getDouble("unit_price"));
                items.add(item);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return items;
    }


        @Override
    public boolean updateItem(String itemCode, Item item, Connection connection) {
        try{
            var ps = connection.prepareStatement(UPDATE_ITEM);
            ps.setString(1, item.getItemName());
            ps.setInt(2, item.getItemQty());
            ps.setDouble(3, item.getUnitPrice());
            ps.setString(4, item.getItemCode());
            return ps.executeUpdate() != 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteItem(String itemCode, Connection connection) {
        try{
            var ps = connection.prepareStatement(DELETE_ITEM);
            ps.setString(1, itemCode);
            return  ps.executeUpdate() != 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
