package com.vr33ni.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "items")
public class Item {

    @Id
    private String id;

    private String name;

    @Field("brand")
    private String brand;

    @Field("type")
    private String type;

    private double price;

    // Constructors
    public Item() {
    }

    public Item(String name, String brand, String type, double price) {
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.price = price;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Optional: toString() method for easy debugging

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
