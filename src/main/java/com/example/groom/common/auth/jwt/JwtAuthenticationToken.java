package com.example.groom.common.auth.jwt;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class JwtAuthenticationToken implements AuthenticationToken{
    private String accessToken;
    private String refreshToken;

}
