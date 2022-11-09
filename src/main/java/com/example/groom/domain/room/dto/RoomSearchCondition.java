package com.example.groom.domain.room.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RoomSearchCondition {
    private String name;
    private String description;
    private LocalDateTime dateLoe;
    private LocalDateTime dateGoe;
    private Long ownerId;
    private Long participantId;
}
