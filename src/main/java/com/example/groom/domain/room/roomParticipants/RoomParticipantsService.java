package com.example.groom.domain.room.roomParticipants;

import com.example.groom.entity.domain.auth.UserInfo;
import com.example.groom.entity.domain.room.Room;
import com.example.groom.entity.domain.room.RoomParticipants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomParticipantsService {
    private final RoomParticipantsRepository roomParticipantsRepository;

    public List<UserInfo> getParticipantsByRoomId(Long roomId){
        return this.roomParticipantsRepository.getParticipantsListUserInfosByRoomId(roomId);
    }

    public Long countParticipantsByRoomId(Long roomId){
        return this.roomParticipantsRepository.countParticipantsByRoomId(roomId);
    }

    public void save(Long id, List<Long> roomParticipantsDto) {
        List<RoomParticipants> roomParticipants = roomParticipantsDto.stream().map(user -> new RoomParticipants(Room.of(id), UserInfo.of(user))).toList();
        this.roomParticipantsRepository.saveAllAndFlush(roomParticipants);
    }
}
