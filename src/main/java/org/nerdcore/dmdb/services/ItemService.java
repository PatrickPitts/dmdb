package org.nerdcore.dmdb.services;

import org.nerdcore.dmdb.entity.GameEntities.Item;
import org.nerdcore.dmdb.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    static ItemRepository itemRepository;

    public static Item saveItem(Item item){

        System.out.println(item.getItemName());

        itemRepository.saveAndFlush(item);
        return item;
    }

    public static List<Item> getAllItems(){
        return itemRepository.findAll();
    }
}
