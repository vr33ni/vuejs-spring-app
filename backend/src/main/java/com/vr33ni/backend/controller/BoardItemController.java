package com.vr33ni.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vr33ni.backend.model.Board;
import com.vr33ni.backend.service.BoardItemService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items/boards")
@CrossOrigin(origins = "http://localhost:5173") 
public class BoardItemController {

    @Autowired
    private BoardItemService boardItemService;

    @GetMapping({ "", "/" }) // Handle both "/" and "" (empty) paths
    public List<Board> getAllItems() {
        return boardItemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Optional<Board> getItemById(@PathVariable String id) {
        return boardItemService.getItemById(id);
    }

    @PostMapping("/")
    public Board createItem(@RequestBody Board item) {
        return boardItemService.createItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable String id) {
        boardItemService.deleteItem(id);
    }

    // New endpoint to find items by brand
    @GetMapping("/brand/{brand}")
    public List<Board> getItemsByBrand(@PathVariable String brand) {
        return boardItemService.getItemsByBrand(brand);
    }

    // New endpoint to find items by type
    @GetMapping("/type/{type}")
    public List<Board> getItemsByType(@PathVariable String type) {
        return boardItemService.getItemsByType(type);
    }

    // Endpoint to find items by name containing substring
    @GetMapping("/search")
    public List<Board> getItemsByNameContaining(@RequestParam String name) {
        return boardItemService.getItemsByNameContaining(name);
    }
}
