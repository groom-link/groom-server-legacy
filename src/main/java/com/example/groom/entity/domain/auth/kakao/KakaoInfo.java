package com.example.groom.entity.domain.auth;


import com.example.groom.common.Class.KakaoAccount;
import com.example.groom.entity.common.DateEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class KakaoInfo extends DateEntity {
    @Id
    @JsonProperty("id")
    private Long id;

    @JsonProperty("kakao_account")
    @Embedded
    private KakaoAccount kakaoAccount;
}

