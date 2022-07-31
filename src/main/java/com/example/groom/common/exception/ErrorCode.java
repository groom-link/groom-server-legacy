package com.example.groom.common.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    ACCESS_TOKEN_REQUIRED(HttpStatus.UNAUTHORIZED, "액세스 토큰이 필요한 요청입니다."),
    REFRESH_TOKEN_REQUIRED(HttpStatus.UNAUTHORIZED, "리프레쉬 토큰이 필요한 요청입니다."),
    ACCESS_TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "액세스 토큰이 만료되었습니다."),
    REFRESH_TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "리프레쉬 토큰이 만료되었습니다."),
    TOKEN_VALIDATE_FAIL(HttpStatus.UNAUTHORIZED, "유효하지 않은 토큰 입니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자 아이디를 찾을 수 없습니다.")
    ;
    private final HttpStatus status;
    private final String message;
}
