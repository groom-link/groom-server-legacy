package com.example.groom.domain.Room;


import com.example.groom.domain.Room.Dto.RoomDetailDto;
import com.example.groom.domain.Room.Dto.RoomDto;
import com.example.groom.domain.Room.Dto.RoomSearchCondition;
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
