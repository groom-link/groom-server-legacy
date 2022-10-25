package com.example.groom.entity.domain.auth;


import com.example.groom.entity.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnore
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    @JoinColumn
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private KakaoInfo kakao;

    protected UserInfo(KakaoInfo kakao, User user){
        this.user = user;
        this.kakao = kakao;
    }

    public UserInfo(Long id) {
        super(id);
    }

    public static UserInfo of(Long id) {
        return new UserInfo(id);
    }

    public static UserInfo of(KakaoInfo kakao, User user){
        return new UserInfo(kakao,user);
    }
}
