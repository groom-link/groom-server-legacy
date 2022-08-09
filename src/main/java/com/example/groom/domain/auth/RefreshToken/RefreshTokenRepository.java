package com.example.groom.domain.auth.RefreshToken;

import com.example.groom.entity.Token;
import com.example.groom.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RefreshTokenRepository extends JpaRepository<Token, Long>, RefreshTokenRepositoryCustom {
    void deleteByUserInfo(UserInfo userInfo);

    boolean existsByUserInfo(UserInfo userInfo);

    boolean existsByRefreshToken(String refreshToken);
}
