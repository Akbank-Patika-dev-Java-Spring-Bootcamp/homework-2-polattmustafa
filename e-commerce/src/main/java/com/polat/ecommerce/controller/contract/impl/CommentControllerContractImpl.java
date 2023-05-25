package com.polat.ecommerce.controller.contract.impl;

import com.polat.ecommerce.controller.contract.CommentControllerContract;
import com.polat.ecommerce.dto.comment.CommentDTO;
import com.polat.ecommerce.dto.comment.CommentSaveRequest;
import com.polat.ecommerce.mapper.CommentMapper;
import com.polat.ecommerce.model.Comment;
import com.polat.ecommerce.model.Customer;
import com.polat.ecommerce.model.Product;
import com.polat.ecommerce.service.CommentEntityService;
import com.polat.ecommerce.service.CustomerEntityService;
import com.polat.ecommerce.service.ProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentControllerContractImpl implements CommentControllerContract {

    private final CommentEntityService commentEntityService;

    private final CustomerEntityService customerEntityService;

    private final ProductEntityService productEntityService;

    @Override
    public CommentDTO save(CommentSaveRequest commentSaveRequest) {

        Customer customer = customerEntityService.findByIdWithControl(commentSaveRequest.customerId());
        Product product = productEntityService.findByIdWithControl(commentSaveRequest.productId());
        Comment comment = CommentMapper.INSTANCE.convertToComment(commentSaveRequest);

        comment.setCustomer(customer);
        comment.setProduct(product);

        comment = commentEntityService.save(comment);

        return CommentMapper.INSTANCE.convertToCommentDTO(comment);
    }

    @Override
    public void delete(Long id) {
        commentEntityService.delete(id);
    }

    @Override
    public List<CommentDTO> findUserComments(Long customerId) {
        Customer customer = customerEntityService.findById(customerId).orElseThrow();
        List<Comment> commentList = customer.getComments();

        return CommentMapper.INSTANCE.convertToCommentDTOList(commentList);
    }


    @Override
    public List<CommentDTO> findAll() {
        List<Comment> commentList = commentEntityService.findAll();
        return CommentMapper.INSTANCE.convertToCommentDTOList(commentList);
    }

    @Override
    public List<CommentDTO> findProductComments(Long productId) {
        Product product = productEntityService.findByIdWithControl(productId);
        List<Comment> commentList = product.getComments();

        return CommentMapper.INSTANCE.convertToCommentDTOList(commentList);
    }

}
