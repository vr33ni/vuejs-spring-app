package com.vr33ni.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vr33ni.backend.model.Item;

public interface ItemRepository extends MongoRepository<Item, String> {
}
