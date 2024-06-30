package com.vr33ni.backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vr33ni.backend.model.Board;

public interface BoardItemRepository extends MongoRepository<Board, String> {
    List<Board> findByBrand(String brand);
    List<Board> findByType(String type);
}
