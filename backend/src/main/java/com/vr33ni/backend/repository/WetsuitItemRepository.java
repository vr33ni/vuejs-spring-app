package com.vr33ni.backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vr33ni.backend.model.Wetsuit;

public interface WetsuitItemRepository extends MongoRepository<Wetsuit, String> {
    List<Wetsuit> findByBrand(String brand);
    List<Wetsuit> findByThickness(String thickness);
}
