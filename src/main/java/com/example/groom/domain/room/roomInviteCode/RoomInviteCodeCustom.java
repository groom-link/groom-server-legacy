package com.example.groom.domain.room.roomInviteCode;

import com.example.groom.domain.room.roomInviteCode.dto.CodeDto;

public interface RoomInviteCodeCustom {
    CodeDto findByRoomId(Long roomId);
}
