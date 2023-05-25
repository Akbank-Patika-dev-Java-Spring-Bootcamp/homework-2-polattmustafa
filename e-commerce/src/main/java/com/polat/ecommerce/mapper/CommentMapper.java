package com.polat.ecommerce.mapper;

import com.polat.ecommerce.dto.comment.CommentDTO;
import com.polat.ecommerce.dto.comment.CommentSaveRequest;
import com.polat.ecommerce.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    Comment convertToComment(CommentSaveRequest request);

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "productId", source = "product.id")
    CommentDTO convertToCommentDTO(Comment comment);

    List<CommentDTO> convertToCommentDTOList(List<Comment> commentList);

}
