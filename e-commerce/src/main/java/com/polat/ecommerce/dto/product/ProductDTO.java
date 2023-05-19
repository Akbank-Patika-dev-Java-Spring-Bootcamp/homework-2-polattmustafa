package com.polat.ecommerce.dto.product;

public record ProductDTO(Long id,
                         String name,
                         String brand,
                         double price,
                         String description) {
}
