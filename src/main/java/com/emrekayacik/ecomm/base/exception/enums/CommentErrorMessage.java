package com.emrekayacik.ecomm.base.exception.enums;

import com.emrekayacik.ecomm.base.exception.BaseErrorMessage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CommentErrorMessage implements BaseErrorMessage {
    COMMENT_NOT_FOUND("Comment not found");

    private final String message;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}