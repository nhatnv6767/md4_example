package com.ra.sesson02.model.dto.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "Product name is required")
    private String productName;
    @NotNull(message = "Price is required")
//    @Min(value = 1, message = "Price must be greater than 0")
    private String price;
    private MultipartFile image;
    private Boolean status;
    private Long categoryId;
}
