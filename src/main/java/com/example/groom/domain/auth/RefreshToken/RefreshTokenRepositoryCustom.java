package com.example.groom.domain.auth.RefreshToken;

import com.example.groom.entity.RefreshToken;

public interface RefreshTokenRepositoryCustom {
    RefreshToken getRefreshTokenFromDB(String refreshToken);

}
