package lk.ijse.gdse.pos.pos.bo;

import lk.ijse.gdse.pos.pos.dao.DaoFactory;
import lk.ijse.gdse.pos.pos.dao.ItemDao;
import lk.ijse.gdse.pos.pos.dao.ItemDaoImpl;
import lk.ijse.gdse.pos.pos.dto.ItemDto;
import lk.ijse.gdse.pos.pos.entity.Item;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ItemBoImpl implements ItemBo{
    ItemDao itemDao = (ItemDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ITEM);
    @Override
    public String saveItem(ItemDto itemDto, Connection connection) {
        return itemDao.saveItem(Item.toEntity(itemDto), connection);
    }

    @Override
    public ItemDto getItem(String itemCode, Connection connection) {
        return ItemDto.toDto(itemDao.getItem(itemCode, connection));
    }

    @Override
    public boolean updateItem(String itemCode, ItemDto itemDto, Connection connection) {
        return itemDao.updateItem(itemCode, Item.toEntity(itemDto), connection);
    }

    @Override
    public boolean deleteItem(String itemCode, Connection connection) {
        return itemDao.deleteItem(itemCode, connection);
    }

    @Override
    public List<ItemDto> getAllItems(Connection connection) {
        List<Item> items = itemDao.getAllItems(connection);
        List<ItemDto> itemDtos = new ArrayList<>();
        for (int i=0; i<items.toArray().length; i++){
            itemDtos.add(ItemDto.toDto(items.get(i)));
        }
        return itemDtos;
    }
}
