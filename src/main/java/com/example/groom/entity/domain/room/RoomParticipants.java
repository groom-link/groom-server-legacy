package com.example.groom.entity.domain.room;


import com.example.groom.entity.domain.auth.UserInfo;
import com.example.groom.entity.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoomParticipants extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Room room;

    public RoomParticipants(Room room, UserInfo userInfo) {
        this.room = room;
        this.userInfo = userInfo;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private UserInfo userInfo;

    public static RoomParticipants of(Long id) {
        return new RoomParticipants(id);
    }

    private RoomParticipants(Long id){
        super(id);
    }
}
