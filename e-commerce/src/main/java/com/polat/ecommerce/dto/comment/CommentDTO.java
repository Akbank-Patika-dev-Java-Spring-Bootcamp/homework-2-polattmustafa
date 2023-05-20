package com.polat.ecommerce.dto.comment;

import com.polat.ecommerce.dto.customer.CustomerDTO;
import com.polat.ecommerce.dto.product.ProductDTO;
import com.polat.ecommerce.model.Customer;
import com.polat.ecommerce.model.Product;

public record CommentDTO(Long id,
                         String explanation,
                         CustomerDTO customer,
                         ProductDTO product) {

}
