package com.polat.ecommerce.dto.comment;

public record CommentSaveRequest(String explanation,
                                 Long customerId,
                                 Long productId) {
}
