package com.vr33ni.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "wetsuits")
public class Wetsuit {

    @Id
    private String id;

    private String name;

    @Field("brand")
    private String brand;

    @Field("thickness")
    private String thickness;

    private double price;

    // Constructors
    public Wetsuit() {
    }

    public Wetsuit(String name, String brand, String thickness, double price) {
        this.name = name;
        this.brand = brand;
        this.thickness = thickness;
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

    public String getThickness() {
        return thickness;
    }

    public void setThickness(String thickness) {
        this.thickness = thickness;
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
        return "Wetsuit{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", thickness='" + thickness + '\'' +
                ", price=" + price +
                '}';
    }
}
