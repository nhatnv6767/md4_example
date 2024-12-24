package com.ra.sesson02.service.product;

import com.ra.sesson02.model.dto.product.ProductRequestDTO;
import com.ra.sesson02.model.dto.product.ProductResponseDTO;
import com.ra.sesson02.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductResponseDTO> findAll();
    Product findById(Long id);
    ProductResponseDTO save(ProductRequestDTO productDTO);
    void delete(Long id);
}
