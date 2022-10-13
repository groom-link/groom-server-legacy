package com.example.groom.domain.auth.user.dto;


import com.example.groom.entity.domain.auth.kakao.KakaoInfo;
import com.example.groom.entity.domain.auth.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserInfoDto {
    private Long id;
    private KakaoInfo kakao;
    private String username;

    protected UserInfoDto(User user){
        this.id = user.getId();
        this.kakao = user.getKakao();
        this.username = user.getUser().getUsername();
    }

    public static UserInfoDto of(User receiver) {
        return new UserInfoDto(receiver);
    }
}
