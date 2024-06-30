package com.vr33ni.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.vr33ni.backend.model.Accessory;
import com.vr33ni.backend.repository.AccessoryItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccessoryItemService {

    @Autowired
    private AccessoryItemRepository accessoryItemRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    // CRUD operations and query methods out of the box - using MongoRepository
    public List<Accessory> getAllItems() {
        return accessoryItemRepository.findAll();
    }

    public Optional<Accessory> getItemById(String id) {
        return accessoryItemRepository.findById(id);
    }

    public Accessory createItem(Accessory accessory) {
        return accessoryItemRepository.save(accessory);
    }

    public void deleteItem(String id) {
        accessoryItemRepository.deleteById(id);
    }

    public List<Accessory> getItemsByBrand(String brand) {
        return accessoryItemRepository.findByBrand(brand);
    }

    public List<Accessory> getItemsByType(String type) {
        return accessoryItemRepository.findByType(type);
    }

    // Custom query - using MongoTemplate
    public List<Accessory> getItemsByNameContaining(String substring) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(substring, "i")); // "i" => case-insensitive
        return mongoTemplate.find(query, Accessory.class);    
    }

}
