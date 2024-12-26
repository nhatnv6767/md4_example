package com.ra.sesson02.service.category;

import com.ra.sesson02.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    Page<Category> findAll(Pageable pageable);
    Category findById(Long id);
    Category save(Category category);
    void deleteById(Long id);
}
