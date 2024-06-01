package com.vr33ni.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.vr33ni.backend.model.Item;
import com.vr33ni.backend.service.ItemService;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private ItemService itemService;

    @Override
    public void run(String... args) throws Exception {
        // Check if the database is empty
        if (itemService.getAllItems().isEmpty()) {
            // Create and save an initial item
            Item item = new Item();
            item.setName("Initial Item");
            item.setPrice(10.0);
            itemService.createItem(item);
            System.out.println("Initial item created");
        }
    }
}
