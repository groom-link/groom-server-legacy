package com.example.groom.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RefreshToken extends BaseEntity{
    @Column
    private String refreshToken;

    @JoinColumn(unique = true)
    @OneToOne(fetch = FetchType.LAZY)
    private UserInfo userInfo;
}
