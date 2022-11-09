package com.example.groom.domain.room.dto;


import com.example.groom.domain.auth.userInfo.dto.UserInfoRoomDto;
import com.example.groom.entity.domain.room.Room;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class RoomDetailDto {
    private Long id;
    private String name;
    private String description;
    private String mainImageUrl;
    private Long maxPeopleNumber;
    private int nowPeopleNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<UserInfoRoomDto> roomParticipants = new ArrayList<>();

    public static RoomDetailDto of(Room room) {
        List<UserInfoRoomDto> roomParticipants = room.getRoomParticipants().stream().map(
                participant -> UserInfoRoomDto.of(participant.getUserInfo())
        ).toList();
        return new RoomDetailDto(
                room.getId(),
                room.getName(),
                room.getDescription(),
                room.getMainImageUrl(),
                room.getMaxPeople(),
                room.getRoomParticipants().size(),
                room.getCreatedAt(),
                room.getUpdatedAt(),
                roomParticipants
        );
    }
}
