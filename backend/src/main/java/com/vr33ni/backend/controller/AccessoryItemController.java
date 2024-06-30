package com.vr33ni.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vr33ni.backend.model.Accessory;
import com.vr33ni.backend.service.AccessoryItemService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items/accessories")
@CrossOrigin(origins = "http://localhost:5173") 
public class AccessoryItemController {

    @Autowired
    private AccessoryItemService accessoryItemService;

    @GetMapping({ "", "/" }) // Handle both "/" and "" (empty) paths
    public List<Accessory> getAllItems() {
        return accessoryItemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Optional<Accessory> getItemById(@PathVariable String id) {
        return accessoryItemService.getItemById(id);
    }

    @PostMapping("/")
    public Accessory createItem(@RequestBody Accessory item) {
        return accessoryItemService.createItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable String id) {
        accessoryItemService.deleteItem(id);
    }

    // New endpoint to find items by brand
    @GetMapping("/brand/{brand}")
    public List<Accessory> getItemsByBrand(@PathVariable String brand) {
        return accessoryItemService.getItemsByBrand(brand);
    }

    // New endpoint to find items by type
    @GetMapping("/type/{type}")
    public List<Accessory> getItemsByType(@PathVariable String type) {
        return accessoryItemService.getItemsByType(type);
    }

    // Endpoint to find items by name containing substring
    @GetMapping("/search")
    public List<Accessory> getItemsByNameContaining(@RequestParam String name) {
        return accessoryItemService.getItemsByNameContaining(name);
    }
}
