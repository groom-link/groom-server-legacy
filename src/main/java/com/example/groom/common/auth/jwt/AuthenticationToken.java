package com.example.groom.common.auth.jwt;

import org.springframework.security.core.Authentication;

public interface AuthenticationToken {
    String getAccessToken();
    String getRefreshToken();
}
