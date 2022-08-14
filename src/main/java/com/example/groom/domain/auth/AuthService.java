package com.example.groom.domain.auth;


import com.example.groom.common.auth.jwt.AuthenticationToken;
import com.example.groom.common.auth.jwt.AuthenticationTokenProvider;
import com.example.groom.domain.auth.RefreshToken.RefreshTokenService;
import com.example.groom.domain.auth.UserInfo.UserInfoService;
import com.example.groom.entity.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final RefreshTokenService refreshTokenService;
    private final AuthenticationTokenProvider authenticationTokenProvider;
    private final KakaoService kakaoService;

    private final UserInfoService userInfoService;

    public AuthenticationToken tokenRefresh(String refreshToken) {
        return this.refreshTokenService.reissue(refreshToken);
    }


    public AuthenticationToken login(String kakaoCode){
        UserInfo userInfo = this.kakaoService.getUserInfoByKakaoAccessToken(kakaoCode);
        return this.authenticationTokenProvider.issue(userInfo.getId());
    }

    public UserInfo getMe(Authentication authentication){
        return this.userInfoService.getUserInfo((Long) authentication.getPrincipal());
    }

}
