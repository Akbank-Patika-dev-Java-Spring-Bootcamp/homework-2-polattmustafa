package com.polat.ecommerce.controller.contract;

import com.polat.ecommerce.dto.comment.CommentDTO;
import com.polat.ecommerce.dto.comment.CommentSaveRequest;

import java.util.List;

public interface CommentControllerContract {

    CommentDTO save(CommentSaveRequest commentSaveRequest, Long productId, Long customerId);

    void delete(Long id);

    List<CommentDTO> findUserComments(Long customerId);

    List<CommentDTO> findAll();

    List<CommentDTO> findProductComments(Long productId);
}
