package com.example.groom.domain.Room.RoomParticipants;

import com.example.groom.entity.UserInfo;

import java.util.List;

public interface RoomParticipantsCustom{
    public List<UserInfo> getParticipantsListUserInfosByRoomId(Long roomId);

    Long countParticipantsByRoomId(Long roomId);
}
