package com.polat.ecommerce.dto.comment;

import com.polat.ecommerce.dto.customer.CustomerSaveRequest;
import com.polat.ecommerce.dto.product.ProductSaveRequest;
import com.polat.ecommerce.model.Customer;
import com.polat.ecommerce.model.Product;

public record CommentSaveRequest(String explanation,
                                 CustomerSaveRequest customer,
                                 ProductSaveRequest product) {
}
