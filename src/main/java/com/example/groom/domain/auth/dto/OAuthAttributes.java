package com.example.groom.domain.auth.dto;

import com.example.groom.common.Class.KakaoAccount;
import com.example.groom.entity.domain.auth.KakaoInfo;
import com.example.groom.entity.domain.auth.UserInfo;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;
@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    private String nickname;

    private String gender;

    private String phoneNumber;

    private

    @Builder OAuthAttributes(Map<String, Object> attributes,
                             String nameAttributeKey, String name,
                             String email, String picture) {
        this.attributes = attributes;
        this.nameAttributeKey= nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public static OAuthAttributes of(String registrationId,
                                     String userNameAttributeName,
                                     Map<String, Object> attributes) {
        if(registrationId.equals("kakao"))return ofKakao(userNameAttributeName, attributes);
        if(registrationId.equals("apple"))return ofApple(userNameAttributeName, attributes);
        return null;
    }

    private static OAuthAttributes ofApple(String userNameAttributeName,
                                            Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofKakao(String userNameAttributeName,
                                           Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get(""))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }


    public UserInfo toEntity() {
        return UserInfo.builder()
                .kakao(KakaoInfo
                        .builder()
                        .id((Long) attributes.get(nameAttributeKey))
                        .kakaoAccount((KakaoAccount) attributes.get("kakao_account"))
                        .build()
                ).build();
    }
}