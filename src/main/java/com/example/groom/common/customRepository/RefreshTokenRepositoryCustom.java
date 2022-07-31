package com.example.groom.common.customRepository;

import com.example.groom.entity.UserInfo;

public interface RefreshTokenRepositoryCustom {
    Boolean checkRefreshToken(String refreshToken, UserInfo userInfo);

    void insertRefreshToken(String refreshToken, UserInfo userInfo);
}
