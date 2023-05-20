package com.emrekayacik.ecomm.base.exception.custom;

import com.emrekayacik.ecomm.base.exception.BaseErrorMessage;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@RequiredArgsConstructor
@MappedSuperclass
public class BusinessException extends RuntimeException{

    private final BaseErrorMessage baseErrorMessage;
}