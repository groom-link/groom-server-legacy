package com.example.groom.common.Class;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Profile {
    @JsonProperty("nickname")
    @Column
    private String nickname;

    @JsonProperty("thumbnail_image_url")
    @Column
    private String thumbnailImageUrl;

    @JsonProperty("profile_image_url")
    @Column
    private String profileImageUrl;
}
