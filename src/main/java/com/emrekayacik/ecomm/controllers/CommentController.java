package com.emrekayacik.ecomm.controllers;

import com.emrekayacik.ecomm.base.response.RestResponse;
import com.emrekayacik.ecomm.controllers.contract.comment.CommentControllerContract;
import com.emrekayacik.ecomm.domain.dto.CommentDto;
import com.emrekayacik.ecomm.domain.dto.ProductDto;
import com.emrekayacik.ecomm.domain.request.ProductModifyPriceRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comments")
@RequiredArgsConstructor
public class CommentController extends BaseController{
    private final CommentControllerContract commentControllerContract;

    @GetMapping("/")
    public ResponseEntity<RestResponse<List<CommentDto>>> get(){
        return genericReturnOk(commentControllerContract.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<CommentDto>> findById(@PathVariable Long id){
        return genericReturnOk(commentControllerContract.findById(id));
    }
    @GetMapping("/user/{userId}/")
    public ResponseEntity<RestResponse<List<CommentDto>>> getCommentsByUserId(@PathVariable Long userId){
        return genericReturnOk(commentControllerContract.getCommentsByUserId(userId));
    }
    @GetMapping("/product/{productId}/")
    public ResponseEntity<RestResponse<List<CommentDto>>> getCommentsByProductId(@PathVariable Long productId){
        return genericReturnOk(commentControllerContract.getCommentsByProductId(productId));
    }
    @PostMapping("/")
    public ResponseEntity<RestResponse<CommentDto>> save(@RequestBody @Valid CommentDto commentDto){
        CommentDto commentDtoResponse = commentControllerContract.save(commentDto);
        return genericReturnOk(commentDtoResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Object>> delete(@PathVariable Long id){
        commentControllerContract.delete(id);
        return genericReturnEmpty();
    }
}
