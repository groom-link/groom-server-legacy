package com.example.groom.domain.room.roomInviteCode;

import com.example.groom.entity.domain.room.RoomInviteCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomInviteCodeRepository extends JpaRepository<RoomInviteCode, Long> ,RoomInviteCodeCustom{
}
