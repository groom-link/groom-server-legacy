package com.example.groom.domain.auth.dto;

import com.example.groom.common.ResponseDto;
import com.example.groom.common.auth.jwt.AuthenticationToken;

import javax.annotation.Nullable;

public class AuthenticationTokenResponseDTO extends ResponseDto<AuthenticationToken> {
    public AuthenticationTokenResponseDTO(@Nullable AuthenticationToken data) {
        super(data);
    }
}
