package com.example.groom.domain.auth.refreshToken;

import com.example.groom.entity.domain.auth.RefreshToken;

public interface RefreshTokenRepositoryCustom {
    RefreshToken getRefreshTokenFromDB(String refreshToken);

}
