package com.omur.crudoperations.service;
import java.util.List;
import com.omur.crudoperations.entity.Product;

public interface ProductService {
    List<Product> getAll();
    void saveProduct(Product product);
    Product getProductById(int id);
    void deleteProduct(int id);
}
