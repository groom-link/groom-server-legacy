package com.example.groom.domain.room.dto;


import com.example.groom.domain.room.roomPenalty.dto.RoomPenaltyPostDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoomPostDto {
    private String name;

    private String description;

    private String mainImageUrl;

    private String summary;

    private Long maxPeople;

    private Long roomCategoryId;

    private List<Long> roomParticipants = new ArrayList<>();

    private RoomPenaltyPostDto roomPenaltyPostDto;

}
