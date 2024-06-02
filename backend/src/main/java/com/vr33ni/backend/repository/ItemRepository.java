package com.vr33ni.backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vr33ni.backend.model.Item;

public interface ItemRepository extends MongoRepository<Item, String> {
    List<Item> findByBrand(String brand);
    List<Item> findByType(String type);
}
