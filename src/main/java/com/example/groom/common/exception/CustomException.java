package com.example.groom.common.exception;


import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{
    ErrorCode errorCode;
}
