package com.emrekayacik.ecomm.domain.dto;

import com.emrekayacik.ecomm.base.dto.BaseDto;

public record CommentDto (Long id, String text, Long productId, Long userId) implements BaseDto {
    @Override
    public Long getId() {
        return id();
    }
}
