package com.example.groom.domain.room;

import com.example.groom.domain.room.dto.RoomDetailDto;
import com.example.groom.domain.room.dto.RoomListResponseDto;
import com.example.groom.domain.room.dto.RoomSearchCondition;
import org.springframework.data.domain.Pageable;

public interface RoomRepositoryCustom {

    RoomDetailDto getRoomDetailDtoByRoomId(Long id);

    RoomListResponseDto searchByCondition(Pageable pageable, RoomSearchCondition condition);
}
