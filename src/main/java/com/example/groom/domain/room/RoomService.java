package com.example.groom.domain.room;


import com.example.groom.domain.room.dto.RoomDetailDto;
import com.example.groom.domain.room.dto.RoomDto;
import com.example.groom.domain.room.dto.RoomSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {


    private final RoomRepository roomRepository;

    public RoomDetailDto getRoomDetailDtoByRoomId(Long id){
        return this.roomRepository.getRoomDetailDtoByRoomId(id);
    }

    public Page<RoomDto> searchRooms(Pageable pageable, RoomSearchCondition condition){
        return this.roomRepository.searchByCondition(pageable, condition);
    }


}
