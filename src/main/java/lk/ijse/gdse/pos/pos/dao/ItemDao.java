package lk.ijse.gdse.pos.pos.dao;

import lk.ijse.gdse.pos.pos.dto.ItemDto;
import lk.ijse.gdse.pos.pos.entity.Item;

import java.sql.Connection;
import java.util.List;

public interface ItemDao extends SuperDao{
    String saveItem(Item item, Connection connection);
    Item getItem(String itemCode, Connection connection);
    boolean updateItem(String itemCode, Item item, Connection connection);
    boolean deleteItem(String itemCode, Connection connection);
    public List<Item> getAllItems(Connection connection);
}
