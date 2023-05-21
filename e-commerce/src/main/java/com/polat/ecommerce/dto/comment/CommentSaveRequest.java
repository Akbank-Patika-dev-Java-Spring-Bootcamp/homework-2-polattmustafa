package com.polat.ecommerce.dto.comment;

import com.polat.ecommerce.dto.customer.CustomerSaveRequest;
import com.polat.ecommerce.dto.product.ProductSaveRequest;

public record CommentSaveRequest(String explanation,
                                 CustomerSaveRequest customer,
                                 ProductSaveRequest product) {
}
