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
public class ResponseDto<T> {
    private final Boolean success;
    private final T data;
    private final ExceptionDto error;

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
    public ResponseDto(CustomException e){
        this.success = false;
        this.data = null;
        this.error = new ExceptionDto(e);
    }

    public ResponseDto(@Nullable Object data){
        this.success = true;
        this.data = (T)data;
        this.error = null;
    }



    public static ResponseEntity toResponseEntity(CustomException e){
        return ResponseEntity.status(e.getErrorCode().getStatus())
                .body(new ResponseDto(e));
    }
}
