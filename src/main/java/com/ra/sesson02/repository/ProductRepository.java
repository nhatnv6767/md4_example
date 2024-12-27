package com.ra.sesson02.repository;

import com.ra.sesson02.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// repository for Product entity
public interface ProductRepository extends JpaRepository<Product, Long> {
    Boolean existsByProductName(String productName);
    // TODO: explain the method
    //

}
