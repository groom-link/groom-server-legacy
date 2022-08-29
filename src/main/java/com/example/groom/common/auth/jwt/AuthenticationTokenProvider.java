package com.example.groom.common.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import javax.servlet.http.HttpServletRequest;

public interface AuthenticationTokenProvider {
    AuthenticationToken getTokenFromHeader(HttpServletRequest request);

    AuthenticationToken issue(Long userInfoId);
    Long getUserInfoId(String accessToken);
    Jws<Claims> validateAccessToken(String token);
    void validateRefreshToken(String token);
}
