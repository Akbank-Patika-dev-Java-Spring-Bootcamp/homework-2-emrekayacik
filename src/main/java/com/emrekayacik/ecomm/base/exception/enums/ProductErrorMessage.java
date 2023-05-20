package com.emrekayacik.ecomm.base.exception.enums;

import com.emrekayacik.ecomm.base.exception.BaseErrorMessage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ProductErrorMessage implements BaseErrorMessage {
    PRODUCT_NOT_FOUND("Product not found");

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
