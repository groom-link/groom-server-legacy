package com.example.groom.domain.auth.RefreshToken;


import com.example.groom.common.auth.jwt.AuthenticationToken;
import com.example.groom.common.auth.jwt.AuthenticationTokenProvider;
import com.example.groom.common.exception.CustomException;
import com.example.groom.common.exception.ErrorCode;
import com.example.groom.entity.Token;
import com.example.groom.entity.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static java.time.LocalDateTime.now;


@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    @Value("${jwt.refresh.expirationDay}")
    private Long expirationDay;
    private final RefreshTokenRepository refreshTokenRepository;
    private final AuthenticationTokenProvider authenticationTokenProvider;

    private boolean isExpired(Token existsToken) {
        if (!existsToken.getCreatedAt().plusDays(expirationDay).isBefore(now())) return false;
        this.refreshTokenRepository.delete(existsToken);
        return true;
    }
    public UserInfo getUserInfoFromToken(String refreshToken){
        Token tokenFromDB = this.refreshTokenRepository.getRefreshTokenFromDB(refreshToken);
        if(isExpired(tokenFromDB))throw new CustomException(ErrorCode.REFRESH_TOKEN_INVALID);
        return tokenFromDB.getUserInfo();
    }

    public void refreshTokenAssign(String refreshToken, UserInfo userInfo){
        if(this.refreshTokenRepository.existsByUserInfo(userInfo))this.refreshTokenRepository.deleteByUserInfo(userInfo);
        this.refreshTokenRepository.save(new Token(refreshToken, userInfo));
    }

    public AuthenticationToken reissue(String refreshToken){
        Token token = this.refreshTokenRepository.getRefreshTokenFromDB(refreshToken);
        UserInfo userInfo = token.getUserInfo();
        AuthenticationToken issue = this.authenticationTokenProvider.issue(userInfo.getId());
        this.refreshTokenRepository.delete(token);
        this.refreshTokenRepository.save(new Token(issue.getRefreshToken(), userInfo));
        return issue;
    }
}
