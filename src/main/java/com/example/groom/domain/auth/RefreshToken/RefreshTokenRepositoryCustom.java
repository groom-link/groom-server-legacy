package com.example.groom.domain.auth.RefreshToken;

import com.example.groom.entity.Token;

public interface RefreshTokenRepositoryCustom {
    Token getRefreshTokenFromDB(String refreshToken);

}
