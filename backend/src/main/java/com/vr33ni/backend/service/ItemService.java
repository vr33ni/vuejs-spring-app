package com.vr33ni.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.vr33ni.backend.model.Item;
import com.vr33ni.backend.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    // CRUD operations and query methods out of the box - using MongoRepository
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(String id) {
        return itemRepository.findById(id);
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public void deleteItem(String id) {
        itemRepository.deleteById(id);
    }

    public List<Item> getItemsByBrand(String brand) {
        return itemRepository.findByBrand(brand);
    }

    public List<Item> getItemsByType(String type) {
        return itemRepository.findByType(type);
    }

    // Custom query - using MongoTemplate
    public List<Item> getItemsByNameContaining(String substring) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(substring, "i")); // "i" => case-insensitive
        return mongoTemplate.find(query, Item.class);    
    }

}
