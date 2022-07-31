package com.example.groom.common.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface AuthenticationTokenProvider {
    AuthenticationToken getTokenFromHeader(HttpServletRequest request);

    AuthenticationToken issue(Long userInfoId);
    Long getUserInfoId(String accessToken);
    Jws<Claims> validateToken(String token);
}
