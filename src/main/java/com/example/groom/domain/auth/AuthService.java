package com.example.groom.domain.auth;


import com.example.groom.common.auth.jwt.AuthenticationToken;
import com.example.groom.common.auth.jwt.AuthenticationTokenProvider;
import com.example.groom.common.auth.jwt.JwtAuthentication;
import com.example.groom.domain.auth.RefreshToken.RefreshTokenService;
import com.example.groom.domain.auth.UserInfo.UserInfoService;
import com.example.groom.entity.UserInfo;
import lombok.RequiredArgsConstructor;
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
        AuthenticationToken issuedToken = this.authenticationTokenProvider.issue(userInfo.getId());
        this.refreshTokenService.refreshTokenAssign(issuedToken.getRefreshToken(), userInfo);
        return issuedToken;
    }

    public UserInfo getMe(JwtAuthentication authentication){
        return this.userInfoService.getUserInfo(authentication.getPrincipal());
    }

}
