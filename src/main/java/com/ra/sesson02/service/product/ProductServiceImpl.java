package com.ra.sesson02.service.product;

import com.ra.sesson02.model.dto.product.ProductRequestDTO;
import com.ra.sesson02.model.dto.product.ProductResponseDTO;
import com.ra.sesson02.model.entity.Product;
import com.ra.sesson02.repository.CategoryRepository;
import com.ra.sesson02.repository.ProductRepository;
import com.ra.sesson02.service.UploadService;
import com.ra.sesson02.service.category.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final UploadService uploadService;
    private final CategoryServiceImpl categoryService;

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
    public Page<ProductResponseDTO> pagination(Pageable pageable) {
        List<Product> products = productRepository.findAll(pageable).getContent();
        List<ProductResponseDTO> responseDTOS;
        responseDTOS = products.stream().map(product -> ProductResponseDTO.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .price(product.getPrice())
                .image(product.getImage())
                .status(product.getStatus())
                .categoryName(product.getCategory().getCategoryName())
                .build()).collect(Collectors.toList());
        return new PageImpl<>(responseDTOS, pageable, responseDTOS.size());
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public ProductResponseDTO save(ProductRequestDTO productDTO) {

        // upload file
        String fileName = null;
        if (productDTO.getImage() != null && !productDTO.getImage().isEmpty()) {
            fileName = uploadService.uploadImage(productDTO.getImage());
        }

        Product product = Product.builder()
                .productName(productDTO.getProductName())
                .price(productDTO.getPrice())
                .image(fileName)
                .status(productDTO.getStatus())
                .category(categoryService.findById(productDTO.getCategoryId()))
                .build();

        Product productNew = productRepository.save(product);
        // convert tu entity -> DTO
        return ProductResponseDTO.builder()
                .id(productNew.getId())
                .productName(productNew.getProductName())
                .price(productNew.getPrice())
                .image(productNew.getImage())
                .status(productNew.getStatus())
                .categoryName(productNew.getCategory().getCategoryName())
                .build();
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }


}
