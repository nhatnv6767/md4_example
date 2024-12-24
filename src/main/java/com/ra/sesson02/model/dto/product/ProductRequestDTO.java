package com.ra.sesson02.model.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductRequestDTO {
    private String productName;
    private String price;
    private MultipartFile image;
    private Boolean status;
    private Long categoryId;
}
