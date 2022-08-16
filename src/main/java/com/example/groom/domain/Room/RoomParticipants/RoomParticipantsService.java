package com.example.groom.domain.Room.RoomParticipants;

import com.example.groom.entity.UserInfo;
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

}
