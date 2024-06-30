package com.vr33ni.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.vr33ni.backend.model.Board;
import com.vr33ni.backend.repository.BoardItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BoardItemService {

    @Autowired
    private BoardItemRepository boardItemRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    // CRUD operations and query methods out of the box - using MongoRepository
    public List<Board> getAllItems() {
        return boardItemRepository.findAll();
    }

    public Optional<Board> getItemById(String id) {
        return boardItemRepository.findById(id);
    }

    public Board createItem(Board board) {
        return boardItemRepository.save(board);
    }

    public void deleteItem(String id) {
        boardItemRepository.deleteById(id);
    }

    public List<Board> getItemsByBrand(String brand) {
        return boardItemRepository.findByBrand(brand);
    }

    public List<Board> getItemsByType(String type) {
        return boardItemRepository.findByType(type);
    }

    // Custom query - using MongoTemplate
    public List<Board> getItemsByNameContaining(String substring) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(substring, "i")); // "i" => case-insensitive
        return mongoTemplate.find(query, Board.class);    
    }

}
