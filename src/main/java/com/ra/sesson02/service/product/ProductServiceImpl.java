package com.ra.sesson02.service.product;

import com.ra.sesson02.model.dto.product.ProductResponseDTO;
import com.ra.sesson02.model.entity.Product;
import com.ra.sesson02.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    @Override
    public List<ProductResponseDTO> findAll() {
        // convert Entity to DTO
        List<Product> products = productRepository.findAll();
        List<ProductResponseDTO> responseDTOS;
        responseDTOS = products.stream().map(product -> ProductResponseDTO.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .price(product.getPrice())
                .image(product.getImage())
                .status(product.getStatus())
                .categoryName(product.getCategory().getCategoryName())
                .build()).collect(Collectors.toList());
        return responseDTOS;
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
