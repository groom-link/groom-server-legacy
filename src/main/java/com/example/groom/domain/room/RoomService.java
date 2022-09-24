package com.example.groom.domain.room;


import com.example.groom.domain.room.dto.RoomDetailDto;
import com.example.groom.domain.room.dto.RoomListDto;
import com.example.groom.domain.room.dto.RoomPostDto;
import com.example.groom.domain.room.dto.RoomSearchCondition;
import com.example.groom.domain.room.roomParticipants.RoomParticipantsService;
import com.example.groom.domain.room.roomPenalty.RoomPenaltyService;
import com.example.groom.entity.domain.room.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RoomService {


    private final RoomRepository roomRepository;

    private final RoomParticipantsService roomParticipantsService;

    private final RoomPenaltyService roomPenaltyService;

    public RoomDetailDto getRoomDetailDtoByRoomId(Long id){
        return this.roomRepository.getRoomDetailDtoByRoomId(id);
    }

    public Page<RoomListDto> searchRooms(Pageable pageable, RoomSearchCondition condition){
        return this.roomRepository.searchByCondition(pageable, condition);
    }

    @Transactional
    public Room postRoom(RoomPostDto roomPostDto){
        Room room = Room.of(roomPostDto);
        this.roomRepository.save(room);
        this.roomParticipantsService.save(room.getId(), roomPostDto.getRoomParticipants());
        this.roomPenaltyService.save(room.getId(), roomPostDto.getRoomPenaltyPostDto());
        return room;
    }


}
