package com.example.groom.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;




@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo extends BaseEntity {


    @JoinColumn
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn
    @OneToOne(fetch = FetchType.LAZY)
    private KakaoInfo kakao;

    public UserInfo(KakaoInfo kakao, User user){
        this.user = user;
        this.kakao = kakao;
    }
}
