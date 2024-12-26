package com.ra.sesson02.controller;

import com.ra.sesson02.model.dto.product.ProductRequestDTO;
import com.ra.sesson02.model.dto.product.ProductResponseDTO;
import com.ra.sesson02.model.entity.Product;
import com.ra.sesson02.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @GetMapping("/pagination")
    public ResponseEntity<Page<ProductResponseDTO>> getAllPage(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "limit", defaultValue = "3") int limit,
            @RequestParam(name = "sortBy", defaultValue = "price") String sortBy,
            @RequestParam(name = "orderBy", defaultValue = "asc") String orderBy
    ){
        Sort sort = orderBy.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page - 1, limit, sort);
        Page<ProductResponseDTO> products = productService.pagination(pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ProductResponseDTO> save(@ModelAttribute ProductRequestDTO product){
        ProductResponseDTO productResponseDTO = productService.save(product);
        return new ResponseEntity<>(productResponseDTO, HttpStatus.CREATED);
    }



}
