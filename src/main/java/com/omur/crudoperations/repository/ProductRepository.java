package com.omur.crudoperations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.omur.crudoperations.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {}
