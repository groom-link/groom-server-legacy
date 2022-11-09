package com.example.groom.domain.room.roomParticipants;

import com.example.groom.entity.domain.auth.UserInfo;
import com.example.groom.entity.domain.room.RoomParticipants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomParticipantsService {
    private final RoomParticipantsRepository roomParticipantsRepository;

    public List<UserInfo> getParticipantsByRoomId(Long roomId) {

        return this.roomParticipantsRepository.getParticipantsListUserInfosByRoomId(roomId);
    }

    public Long countParticipantsByRoomId(Long roomId) {
        return this.roomParticipantsRepository.countParticipantsByRoomId(roomId);
    }

    public void save(RoomParticipants roomParticipants) {
        this.roomParticipantsRepository.save(roomParticipants);
    }

    public void saveAll(Long roomId, List<Long> roomParticipants) {
        List<RoomParticipants> participants = roomParticipants.stream().map(rp -> RoomParticipants.of(roomId, rp)).toList();
        this.roomParticipantsRepository.saveAll(participants);
    }
}
