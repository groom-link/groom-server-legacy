package com.example.groom.domain.Room.RoomParticipants;

import com.example.groom.entity.RoomParticipants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomParticipantsRepository extends JpaRepository<RoomParticipants, Long>, RoomParticipantsCustom {

}
