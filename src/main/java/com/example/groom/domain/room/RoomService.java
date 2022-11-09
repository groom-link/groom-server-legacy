package com.example.groom.domain.room;


import com.example.groom.domain.room.dto.RoomDetailDto;
import com.example.groom.domain.room.dto.RoomListResponseDto;
import com.example.groom.domain.room.dto.RoomPostDto;
import com.example.groom.domain.room.dto.RoomSearchCondition;
import com.example.groom.domain.room.roomInviteCode.RoomInviteCodeService;
import com.example.groom.domain.room.roomInviteCode.dto.CodeDto;
import com.example.groom.domain.room.roomParticipants.RoomParticipantsService;
import com.example.groom.entity.domain.room.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomParticipantsService roomParticipantsService;
    private final RoomInviteCodeService roomInviteCodeService;

    public RoomDetailDto getRoomDetailDtoByRoomId(Long id) {
        return RoomDetailDto.of(this.roomRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 방입니다.")));
    }

    public RoomListResponseDto searchRooms(Pageable pageable, RoomSearchCondition condition) {
        return this.roomRepository.searchByCondition(pageable, condition);
    }

    @Transactional
    public CodeDto postRoom(RoomPostDto roomPostDto) {
        Room room = this.roomRepository.save(Room.of(roomPostDto));
        this.roomParticipantsService.saveAll(room.getId(), roomPostDto.getRoomParticipants());

        // 코드 생성
        CodeDto codeDto = roomInviteCodeService.save(room.getId());

        return codeDto;
    }
}
