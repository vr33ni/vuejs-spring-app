package com.vr33ni.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vr33ni.backend.model.Wetsuit;
import com.vr33ni.backend.service.WetsuitItemService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items/wetsuits")
@CrossOrigin(origins = "http://localhost:5173") 
public class WetsuitItemController {

    @Autowired
    private WetsuitItemService wetsuitItemService;

    @GetMapping({ "", "/" }) // Handle both "/" and "" (empty) paths
    public List<Wetsuit> getAllItems() {
        return wetsuitItemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Optional<Wetsuit> getItemById(@PathVariable String id) {
        return wetsuitItemService.getItemById(id);
    }

    @PostMapping("/")
    public Wetsuit createItem(@RequestBody Wetsuit item) {
        return wetsuitItemService.createItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable String id) {
        wetsuitItemService.deleteItem(id);
    }

    // New endpoint to find items by brand
    @GetMapping("/brand/{brand}")
    public List<Wetsuit> getItemsByBrand(@PathVariable String brand) {
        return wetsuitItemService.getItemsByBrand(brand);
    }

    // New endpoint to find items by thickness
    @GetMapping("/thickness/{thickness}")
    public List<Wetsuit> getItemsByType(@PathVariable String thickness) {
        return wetsuitItemService.getItemsByThickness(thickness);
    }

    // Endpoint to find items by name containing substring
    @GetMapping("/search")
    public List<Wetsuit> getItemsByNameContaining(@RequestParam String name) {
        return wetsuitItemService.getItemsByNameContaining(name);
    }
}
