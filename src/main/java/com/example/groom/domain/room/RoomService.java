package com.example.groom.domain.room;


import com.example.groom.domain.room.dto.RoomDetailDto;
import com.example.groom.domain.room.dto.RoomDto;
import com.example.groom.domain.room.dto.RoomPostDto;
import com.example.groom.domain.room.dto.RoomSearchCondition;
import com.example.groom.domain.room.roomParticipants.RoomParticipantsService;
import com.example.groom.domain.room.roomPenalty.RoomPenaltyService;
import com.example.groom.entity.domain.room.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {


    private final RoomRepository roomRepository;

    private final RoomPenaltyService roomPenaltyService;

    private final RoomParticipantsService roomParticipantsService;

    public RoomDetailDto getRoomDetailDtoByRoomId(Long id){
        return this.roomRepository.getRoomDetailDtoByRoomId(id);
    }

    public Page<RoomDto> searchRooms(Pageable pageable, RoomSearchCondition condition){
        return this.roomRepository.searchByCondition(pageable, condition);
    }

    public Room postRoom(RoomPostDto roomPostDto) {
        Room room = Room.of(roomPostDto);
        this.roomPenaltyService.save(roomPostDto.getRoomPenaltyPostDto());
        this.roomParticipantsService.save(roomPostDto.getRoomParticipants());
        return this.roomRepository.save(room);
    }
}
