package com.example.groom.common;

import com.example.groom.common.exception.CustomException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Builder
@Getter
public class ExceptionDto {
    private final HttpStatus status;
    private final String code;
    private final String message;

    public ExceptionDto(CustomException e) {
        this.status = e.getErrorCode().getStatus();
        this.code = e.getErrorCode().name();
        this.message = e.getErrorCode().getMessage();
    }
}
