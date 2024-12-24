package com.ra.sesson02.controller;

import com.ra.sesson02.model.dto.product.ProductRequestDTO;
import com.ra.sesson02.model.dto.product.ProductResponseDTO;
import com.ra.sesson02.model.entity.Product;
import com.ra.sesson02.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAll(){
        List<ProductResponseDTO> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> save(@ModelAttribute ProductRequestDTO product){
        ProductResponseDTO productResponseDTO = productService.save(product);
        return new ResponseEntity<>(productResponseDTO, HttpStatus.CREATED);
    }


}
