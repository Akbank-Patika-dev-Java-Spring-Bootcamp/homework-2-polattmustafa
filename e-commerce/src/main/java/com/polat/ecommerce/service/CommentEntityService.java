package com.polat.ecommerce.service;

import com.polat.ecommerce.model.Comment;
import com.polat.ecommerce.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentEntityService extends BaseEntityService<Comment, CommentRepository>{

    public CommentEntityService(CommentRepository anyRepo) {
        super(anyRepo);
    }
}
