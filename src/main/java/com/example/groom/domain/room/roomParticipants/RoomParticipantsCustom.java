package com.example.groom.domain.room.roomParticipants;

import com.example.groom.entity.domain.auth.UserInfo;

import java.util.List;

public interface RoomParticipantsCustom{
    List<UserInfo> getParticipantsListUserInfosByRoomId(Long roomId);

    Long countParticipantsByRoomId(Long roomId);
}
