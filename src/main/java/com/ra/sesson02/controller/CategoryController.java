package com.ra.sesson02.controller;

import com.ra.sesson02.model.dto.DataError;
import com.ra.sesson02.model.entity.Category;
import com.ra.sesson02.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> index(){
        List<Category> categories = categoryService.findAll();
        //
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Category> add(@RequestBody Category category){
        Category newCategory = categoryService.save(category);
        // 201
        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Category category = categoryService.findById(id);
        if(category == null){
            return new ResponseEntity<>(new DataError("category not found", 404), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody Category category){
        Category updateCategory = categoryService.findById(id);
        if(updateCategory == null){
            return new ResponseEntity<>(new DataError("category not found", 404), HttpStatus.NOT_FOUND);
        }
        updateCategory.setCategoryName(category.getCategoryName());
        updateCategory.setCategoryStatus(category.getCategoryStatus());
        categoryService.save(updateCategory);
        return new ResponseEntity<>(updateCategory, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        Category category = categoryService.findById(id);
        if(category == null){
            return new ResponseEntity<>(new DataError("category not found", 404), HttpStatus.NOT_FOUND);
        }
        categoryService.deleteById(id);
        return new ResponseEntity<>(new DataError("category deleted", 200), HttpStatus.OK);
    }
}
