package com.ra.sesson02.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name", length = 100, unique = true, nullable = false)
    private String categoryName;

    @Column(name = "category_status")
    private Boolean categoryStatus;

//    @OneToMany(mappedBy = "category")
//    private Set<Product> products;
}
