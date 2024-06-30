package com.vr33ni.backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vr33ni.backend.model.Accessory;

public interface AccessoryItemRepository extends MongoRepository<Accessory, String> {
    List<Accessory> findByBrand(String brand);
    List<Accessory> findByType(String type);
}
