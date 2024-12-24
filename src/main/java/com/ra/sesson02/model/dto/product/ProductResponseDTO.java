package com.ra.sesson02.model.dto.product;

import jakarta.persistence.Column;

public class ProductResponseDTO {
    private Long id;
    private String productName;
    private String price;
    private String image;
    private Boolean status;
    private String categoryName;
}
