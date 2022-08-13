package com.example.groom.entity;


import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class RoomParticipants extends BaseEntity{
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private UserInfo userInfo;
}
