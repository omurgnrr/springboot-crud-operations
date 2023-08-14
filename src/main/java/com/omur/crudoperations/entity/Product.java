package com.omur.crudoperations.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 128, nullable = false)
    @NotEmpty(message = "Product's name cannot be empty.")
    @Size(min = 1, max = 100, message = "Size must between 1 and 100.")
    private String name;

    @Column(length = 128, nullable = false)
    @Size(min = 1, max = 100, message = "Size must between 1 and 100.")
    @NotEmpty(message = "Product's category cannot be empty.")
    private String category;

    @Column(length = 128, nullable = false)
    @NotNull(message = "Product's price cannot be empty.")
    @Min(value = 1, message = "Size must between 0 and 1000000")
    @Max(value = 1000000, message = "Size must be less than 1000000")
    private Double price;

    public Product() {
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + "]";
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
}
