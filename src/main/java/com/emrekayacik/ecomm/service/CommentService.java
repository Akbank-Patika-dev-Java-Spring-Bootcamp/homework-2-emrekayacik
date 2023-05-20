package com.emrekayacik.ecomm.service;

import com.emrekayacik.ecomm.base.service.BaseEntityService;
import com.emrekayacik.ecomm.dao.CommentRepository;
import com.emrekayacik.ecomm.domain.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService extends BaseEntityService<Comment, CommentRepository> {
    private final CommentRepository repository;
    public CommentService(CommentRepository repository) {
        super(repository);
        this.repository = repository;
    }
    public List<Comment> getCommentsByUserId(Long userId){
        return repository.getCommentsByUserId(userId);
    }
    public List<Comment> getCommentsByProductId(Long productId){
        return repository.getCommentsByProductId(productId);
    }
}
