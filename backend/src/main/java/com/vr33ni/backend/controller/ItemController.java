package com.vr33ni.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vr33ni.backend.model.Item;
import com.vr33ni.backend.service.ItemService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping({ "", "/" }) // Handle both "/" and "" (empty) paths
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable String id) {
        return itemService.getItemById(id);
    }

    @PostMapping("/")
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable String id) {
        itemService.deleteItem(id);
    }

    // New endpoint to find items by brand
    @GetMapping("/brand/{brand}")
    public List<Item> getItemsByBrand(@PathVariable String brand) {
        return itemService.getItemsByBrand(brand);
    }

    // New endpoint to find items by type
    @GetMapping("/type/{type}")
    public List<Item> getItemsByType(@PathVariable String type) {
        return itemService.getItemsByType(type);
    }

    // Endpoint to find items by name containing substring
    @GetMapping("/search")
    public List<Item> getItemsByNameContaining(@RequestParam String name) {
        return itemService.getItemsByNameContaining(name);
    }
}
