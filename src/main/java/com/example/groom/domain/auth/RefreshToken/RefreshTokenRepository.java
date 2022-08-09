package com.example.groom.domain.auth.RefreshToken;

import com.example.groom.entity.RefreshToken;
import com.example.groom.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>, RefreshTokenRepositoryCustom {
    void deleteByUserInfo(UserInfo userInfo);

    boolean existsByUserInfo(UserInfo userInfo);

    boolean existsByRefreshToken(String refreshToken);
}
