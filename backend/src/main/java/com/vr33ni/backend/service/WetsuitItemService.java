package com.vr33ni.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.vr33ni.backend.model.Wetsuit;
import com.vr33ni.backend.repository.WetsuitItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WetsuitItemService {

    @Autowired
    private WetsuitItemRepository wetsuitItemRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    // CRUD operations and query methods out of the box - using MongoRepository
    public List<Wetsuit> getAllItems() {
        return wetsuitItemRepository.findAll();
    }

    public Optional<Wetsuit> getItemById(String id) {
        return wetsuitItemRepository.findById(id);
    }

    public Wetsuit createItem(Wetsuit item) {
        return wetsuitItemRepository.save(item);
    }

    public void deleteItem(String id) {
        wetsuitItemRepository.deleteById(id);
    }

    public List<Wetsuit> getItemsByBrand(String brand) {
        return wetsuitItemRepository.findByBrand(brand);
    }

    public List<Wetsuit> getItemsByThickness(String thickness) {
        return wetsuitItemRepository.findByThickness(thickness);
    }

    // Custom query - using MongoTemplate
    public List<Wetsuit> getItemsByNameContaining(String substring) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(substring, "i")); // "i" => case-insensitive
        return mongoTemplate.find(query, Wetsuit.class);    
    }

}
