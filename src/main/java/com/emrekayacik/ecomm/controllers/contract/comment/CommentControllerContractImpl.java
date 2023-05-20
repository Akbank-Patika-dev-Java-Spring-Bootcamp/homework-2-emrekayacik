package com.emrekayacik.ecomm.controllers.contract.comment;

import com.emrekayacik.ecomm.base.exception.enums.CommentErrorMessage;
import com.emrekayacik.ecomm.base.exception.GenericErrorMessage;
import com.emrekayacik.ecomm.base.exception.custom.ItemNotFoundException;
import com.emrekayacik.ecomm.base.exception.enums.ProductErrorMessage;
import com.emrekayacik.ecomm.base.exception.enums.UserErrorMessage;
import com.emrekayacik.ecomm.domain.dto.CommentDto;
import com.emrekayacik.ecomm.domain.dto.ProductDto;
import com.emrekayacik.ecomm.domain.entity.Product;
import com.emrekayacik.ecomm.domain.entity.User;
import com.emrekayacik.ecomm.infrastructure.mapper.CommentMapper;
import com.emrekayacik.ecomm.service.CommentService;
import com.emrekayacik.ecomm.service.ProductService;
import com.emrekayacik.ecomm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RequiredArgsConstructor
@Service
public class CommentControllerContractImpl implements CommentControllerContract{
    private final CommentService commentService;
    private final ProductService productService;
    private final UserService userService;
    private CommentMapper INSTANCE = getMapper();
    @Override
    public CommentDto save(CommentDto DTO) {
        itemExistsByIdOrThrowException(DTO.productId(), productService::findById, ProductErrorMessage.PRODUCT_NOT_FOUND.getMessage());
        itemExistsByIdOrThrowException(DTO.userId(), userService::findById, UserErrorMessage.USER_NOT_FOUND.getMessage());

        return INSTANCE.convertToDto(commentService.save(INSTANCE.convertToEntity(DTO)));
    }

    @Override
    public List<CommentDto> findAll() {
        return INSTANCE.convertToDtoList(commentService.findAll());
    }

    @Override
    public void delete(Long id) {
        CommentDto commentDto = getCommentByIdOrThrowException(id);
        commentService.delete(INSTANCE.convertToEntity(commentDto));
    }

    @Override
    public CommentDto findById(Long id) {
        return getCommentByIdOrThrowException(id);
    }



    @Override
    public CommentDto update(CommentDto userDto) {
        return INSTANCE.convertToDto(commentService.save(INSTANCE.convertToEntity(userDto)));
    }

    @Override
    public List<CommentDto> getCommentsByUserId(Long userId) {
        itemExistsByIdOrThrowException(userId, userService::findById, UserErrorMessage.USER_NOT_FOUND.getMessage());
        List<CommentDto> commentDtoList = INSTANCE.convertToDtoList(commentService.getCommentsByUserId(userId));
        if(commentDtoList.size() == 0){
            throw new ItemNotFoundException(() -> "The user hasn't have any comments");
        }
        return commentDtoList;
    }

    @Override
    public List<CommentDto> getCommentsByProductId(Long productId) {
        itemExistsByIdOrThrowException(productId, productService::findById, ProductErrorMessage.PRODUCT_NOT_FOUND.getMessage());
        List<CommentDto> commentDtoList = INSTANCE.convertToDtoList(commentService.getCommentsByProductId(productId));
        if(commentDtoList.size() == 0){
            throw new ItemNotFoundException(() -> "There are no comments for this product.");
        }
        return commentDtoList;
    }

    private CommentMapper getMapper(){
        return Mappers.getMapper(CommentMapper.class);
    }
    private CommentDto getCommentByIdOrThrowException(Long id) {

        CommentDto commentDto = INSTANCE.convertToDto(commentService.findById(id).orElseThrow(
                () -> new ItemNotFoundException(
                        GenericErrorMessage.builder().message(
                                CommentErrorMessage.COMMENT_NOT_FOUND.getMessage()
                        ).build()
                )
        ));
        return commentDto;
    }
    private <T> void itemExistsByIdOrThrowException(Long id, Function<Long, Optional<T>> findFunction, String errorMessage) {
        findFunction.apply(id).orElseThrow(
                () -> new ItemNotFoundException(
                        GenericErrorMessage.builder().message(errorMessage).build()
                )
        );
    }
}
