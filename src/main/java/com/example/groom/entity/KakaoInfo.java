package com.example.groom.entity;


import com.example.groom.common.Class.KakaoAccount;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KakaoInfo extends DateEntity{
    @Id
    @JsonProperty("id")
    private Long id;

    @JsonProperty("kakao_account")
    @Embedded
    private KakaoAccount kakaoAccount;
}


