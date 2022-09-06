package com.example.groom.entity;

import com.example.groom.entity.enums.RequestStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestUser {

    @JsonProperty("id")
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private RequestStatus status;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Request excuse;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo userInfo;
}
