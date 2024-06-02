package com.vr33ni.backend.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

@Component
public class DatabaseCleaner {

    private final MongoTemplate mongoTemplate;
    private final MongoClient mongoClient;

    @Autowired
    public DatabaseCleaner(MongoTemplate mongoTemplate, MongoClient mongoClient) {
        this.mongoTemplate = mongoTemplate;
        this.mongoClient = mongoClient;
    }

    public void cleanCollections() {
        mongoTemplate.getDb().drop();
        System.out.println("All collections dropped successfully.");
    }

    public void cleanDatabases(String... databaseNames) {
        
        for (String dbName : databaseNames) {
            MongoDatabase database = mongoClient.getDatabase(dbName);
            database.drop();
            System.out.println("Database '" + dbName + "' dropped successfully.");
        }
    }
}
