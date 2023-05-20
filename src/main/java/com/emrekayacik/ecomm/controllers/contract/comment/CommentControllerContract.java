package com.emrekayacik.ecomm.controllers.contract.comment;

import com.emrekayacik.ecomm.controllers.contract.BaseControllerContract;
import com.emrekayacik.ecomm.domain.dto.CommentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentControllerContract extends BaseControllerContract<CommentDto> {
    List<CommentDto> getCommentsByUserId(Long userId);
    List<CommentDto> getCommentsByProductId(Long productId);
}
