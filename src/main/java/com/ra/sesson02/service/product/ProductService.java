package com.ra.sesson02.service.product;

import com.ra.sesson02.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    void delete(Long id);
}
