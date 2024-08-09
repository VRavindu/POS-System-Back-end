package lk.ijse.gdse.pos.pos.entity;

import lk.ijse.gdse.pos.pos.dto.ItemDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Item {
    private String itemCode;
    private String itemName;
    private int itemQty;
    private double unitPrice;

    public static Item toEntity(ItemDto itemDto){
        Item item = new Item();
        item.setItemCode(itemDto.getItemCode());
        item.setItemName(itemDto.getItemName());
        item.setItemQty(itemDto.getItemQty());
        item.setUnitPrice(itemDto.getUnitPrice());
        return item;
    }
}
