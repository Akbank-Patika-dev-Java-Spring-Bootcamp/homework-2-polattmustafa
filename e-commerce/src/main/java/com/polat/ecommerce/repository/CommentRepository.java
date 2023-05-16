package com.polat.ecommerce.repository;

import com.polat.ecommerce.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
