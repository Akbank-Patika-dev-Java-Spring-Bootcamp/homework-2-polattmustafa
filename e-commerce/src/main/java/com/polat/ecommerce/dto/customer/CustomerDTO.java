package com.polat.ecommerce.dto.customer;

import com.polat.ecommerce.enums.EnumCustomerType;

public record CustomerDTO(Long id,
                          String name,
                          String surname,
                          String username,
                          String email,
                          String phone,
                          EnumCustomerType type) {
}
