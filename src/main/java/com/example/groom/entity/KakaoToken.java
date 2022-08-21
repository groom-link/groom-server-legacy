package com.example.groom.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class KakaoToken extends BaseEntity{

    @Column
    private String accessToken;

    @Column
    private String refreshToken;

    @JoinColumn
    @OneToOne(fetch = FetchType.LAZY)
    private KakaoInfo kakaoInfo;
}
