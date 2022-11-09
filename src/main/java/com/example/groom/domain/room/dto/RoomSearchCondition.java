package com.example.groom.domain.room.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RoomSearchCondition {
    private String name;
    private String summary;
    private String description;
    private Boolean isMax;
    private List<String> Category;
    private LocalDateTime dateLoe;
    private LocalDateTime dateGoe;
    private Long ownerId;

}
