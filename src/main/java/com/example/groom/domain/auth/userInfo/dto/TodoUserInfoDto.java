package com.example.groom.domain.auth.userInfo.dto;

import com.example.groom.entity.domain.auth.UserInfo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TodoUserInfoDto {

    private Long todoOwnerId;

    private String nickname;

    private String profileImage;

    public static TodoUserInfoDto of(UserInfo userInfo) {
        return TodoUserInfoDto.builder()
                .todoOwnerId(userInfo.getId())
                .nickname(userInfo.getKakao().getKakaoAccount().getProfile().getNickname())
                .profileImage(userInfo.getKakao().getKakaoAccount().getProfile().getProfileImageUrl())
                .build();
    }
}
