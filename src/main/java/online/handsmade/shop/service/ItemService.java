package online.handsmade.shop.service;

import online.handsmade.shop.model.Item;
import online.handsmade.shop.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    private ItemRepo itemRepo;

    public Item save(Item item) {
        return itemRepo.save(item);
    }


}
