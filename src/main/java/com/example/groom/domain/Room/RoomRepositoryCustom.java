package com.example.groom.domain.Room;

import com.example.groom.domain.Room.Dto.RoomDetailDto;
import com.example.groom.domain.Room.Dto.RoomDto;
import com.example.groom.domain.Room.Dto.RoomSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoomRepositoryCustom {

    RoomDetailDto getRoomDetailDtoByRoomId(Long id);

    Page<RoomDto> searchByCondition(Pageable pageable, RoomSearchCondition condition);
}
