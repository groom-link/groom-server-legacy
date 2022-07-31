package com.example.groom.entity;


import com.example.groom.entity.enums.Gender;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class UserInfo extends BaseEntity {
    @JoinColumn
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @Column
    private String kakaoCode;

    @Column
    private String kakaoEmail;

    @Column
    private String profileThumbnailImageUrl;

    @Column
    private String nickname;

    @Column
    private String name;
    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    private String ageRange;
}
