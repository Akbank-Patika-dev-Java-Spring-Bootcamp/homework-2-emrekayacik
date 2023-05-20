package com.emrekayacik.ecomm.dao;

import com.emrekayacik.ecomm.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CommentRepository  extends JpaRepository<Comment, Long> {
    List<Comment> getCommentsByUserId(Long userId);
    List<Comment> getCommentsByProductId(Long productId);
}
