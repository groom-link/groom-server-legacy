package com.example.groom.common;


import com.example.groom.common.exception.CustomException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.annotation.Nullable;


@AllArgsConstructor
@Builder
@Getter
class ExceptionDto{
    private final HttpStatus status;
    private final String code;
    private final String message;

    public ExceptionDto(CustomException e){
        this.status = e.getErrorCode().getStatus();
        this.code = e.getErrorCode().name();
        this.message = e.getErrorCode().getMessage();
    }
}
@AllArgsConstructor
@Builder
@Getter
public class ResponseDto<T> {
    private final Boolean success;
    private final T data;
    private final ExceptionDto error;



    public ResponseDto(@Nullable T data, @Nullable CustomException e){
        this.success = e == null;
        this.data = data;
        this.error = e != null ? new ExceptionDto(e) : null;
    }



    public static ResponseEntity<Object> toResponseEntity(ResponseDto<Object> res){
        return ResponseEntity.status(res.getError().getStatus())
                .body(res);
    }
}
