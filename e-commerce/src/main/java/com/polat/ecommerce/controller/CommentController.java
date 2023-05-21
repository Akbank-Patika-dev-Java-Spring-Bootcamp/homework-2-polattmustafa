package com.polat.ecommerce.controller;

import com.polat.ecommerce.controller.contract.CommentControllerContract;
import com.polat.ecommerce.dto.comment.CommentDTO;
import com.polat.ecommerce.dto.comment.CommentSaveRequest;
import com.polat.ecommerce.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentControllerContract commentControllerContract;

    @PostMapping("/save/{ID_PRODUCT}/{ID_CUSTOMER}")
    public ResponseEntity<RestResponse<CommentDTO>> save(@RequestBody CommentSaveRequest commentSaveRequest,
                                                         @PathVariable("ID_PRODUCT") Long productId,
                                                         @PathVariable("ID_CUSTOMER") Long customerId) {
        var commentDTO = commentControllerContract.save(commentSaveRequest, productId, customerId);
        return ResponseEntity.ok(RestResponse.of(commentDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Object>> delete(@PathVariable Long id) {
        commentControllerContract.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

    @GetMapping("/user/{ID_CUSTOMER}")
    public ResponseEntity<RestResponse<List<CommentDTO>>> findUserComments(@PathVariable("ID_CUSTOMER") Long customerId) {
        var commentDTOList = commentControllerContract.findUserComments(customerId);
        if (commentDTOList == null || commentDTOList.size() == 0) {
            return ResponseEntity.ok(RestResponse.errorMessage(String.format("Id:%s customer has not yet commented", customerId)));
        } else {
            return ResponseEntity.ok(RestResponse.of(commentDTOList));
        }
    }

    @GetMapping("/product/{ID_PRODUCT}")
    public ResponseEntity<RestResponse<List<CommentDTO>>> findProductComments(@PathVariable("ID_PRODUCT") Long productId) {
        var commentDTOList = commentControllerContract.findProductComments(productId);
        if (commentDTOList == null || commentDTOList.size() == 0) {
            return ResponseEntity.ok(RestResponse.errorMessage(String.format("Id:%s product has not given comment yet", productId)));
        } else {
            return ResponseEntity.ok(RestResponse.of(commentDTOList));
        }
    }

    @GetMapping("/user")
    public ResponseEntity<RestResponse<List<CommentDTO>>> findAll() {
        var commentDTOList = commentControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(commentDTOList));
    }

}
