package com.example.groom.domain.auth;


import com.example.groom.common.auth.jwt.AuthenticationToken;
import com.example.groom.common.auth.jwt.AuthenticationTokenProvider;
import com.example.groom.common.auth.jwt.JwtAuthentication;
import com.example.groom.domain.auth.dto.OAuthAttributes;
import com.example.groom.domain.auth.refreshToken.RefreshTokenService;
import com.example.groom.domain.auth.userInfo.UserInfoService;
import com.example.groom.entity.domain.auth.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

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
        this.refreshTokenService.assignRefreshToken(issuedToken.getRefreshToken(), userInfo);
        return issuedToken;
    }

    public UserInfo getMe(JwtAuthentication authentication){
        return this.userInfoService.getUserInfo(authentication.getPrincipal());
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        DefaultOAuth2UserService service = new DefaultOAuth2UserService();
        OAuth2User user = service.loadUser(userRequest);
        String id = userRequest.getClientRegistration().getRegistrationId();
        String name = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();
        OAuthAttributes attributes = OAuthAttributes.of(id, name, user.getAttributes());
        System.out.println("asd");
        return null;
    }
}
