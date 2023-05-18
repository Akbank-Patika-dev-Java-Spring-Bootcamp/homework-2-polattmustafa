package com.polat.ecommerce.dto;

import com.polat.ecommerce.enums.EnumCustomerType;

public record CustomerSaveRequest(String name,
                                  String surname,
                                  String username,
                                  String password,
                                  String email,
                                  String phone,
                                  EnumCustomerType type) {
}
