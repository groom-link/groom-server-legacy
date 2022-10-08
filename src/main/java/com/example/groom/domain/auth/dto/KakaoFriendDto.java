package com.example.groom.domain.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class KakaoFriendDto {
    private Long id;
    private String uuid;
    private Boolean favorite;

    @JsonProperty("profile_nickname")
    private String nickname;

    @JsonProperty("profile_thumbnail_image")
    private String picture;
}
