package com.example.groom.common.Class;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class KakaoAccount {

    @JsonProperty("profile")
    @Embedded
    private Profile profile;


    @JsonProperty("name")
    @Column
    private String name;

    @JsonProperty("email")
    @Column
    private String email;

    @JsonProperty("age_range")
    @Column
    private String ageRange;

    @JsonProperty("birthday")
    @Column
    private String birthDay;

    @JsonProperty("gender")
    @Column
    private String gender;

    @JsonProperty("phone_number")
    @Column
    private String phoneNumber;
}
