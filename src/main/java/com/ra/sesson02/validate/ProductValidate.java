package com.ra.sesson02.validate;

import com.ra.sesson02.repository.ProductRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductValidate implements ConstraintValidator<ProductUnique, String> {
    private final ProductRepository productRepository;
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !productRepository.existsByProductName(value);
    }
}
