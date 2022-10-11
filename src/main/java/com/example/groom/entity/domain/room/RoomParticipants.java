package com.example.groom.entity.domain.room;


import com.example.groom.entity.domain.auth.UserInfo;
import com.example.groom.entity.common.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoomParticipants extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private UserInfo userInfo;

    public static RoomParticipants of(Long id) {
        return new RoomParticipants(id);
    }

    private RoomParticipants(Long id){
        super(id);
    }

    public static RoomParticipants of(Long roomId, Long userId){
        return RoomParticipants.builder().room(Room.of(roomId)).userInfo(UserInfo.of(userId)).build();
    }
}
