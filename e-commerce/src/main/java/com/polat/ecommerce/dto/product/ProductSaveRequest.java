package com.polat.ecommerce.dto.product;

public record ProductSaveRequest(String name,
                                 String brand,
                                 double price,
                                 String description) {
}
