package com.ra.sesson02.model.dto.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
//@JsonIgnoreProperties({"sort", ""})
public class ProductResponseDTO {
    private Long id;
    private String productName;
    private String price;
    private String image;
    private Boolean status;
    private String categoryName;
}
