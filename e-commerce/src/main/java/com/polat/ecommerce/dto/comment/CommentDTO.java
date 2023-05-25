package com.polat.ecommerce.dto.comment;

import com.polat.ecommerce.dto.customer.CustomerDTO;
import com.polat.ecommerce.dto.product.ProductDTO;

public record CommentDTO(Long id,
                         String explanation,
                         Long customerId,
                         Long productId) {

}
