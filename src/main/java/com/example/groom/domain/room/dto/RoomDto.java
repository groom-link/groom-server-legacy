package com.example.groom.domain.Room.Dto;


import com.example.groom.entity.UserInfo;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RoomDto {
    private Long id;
    private String name;
    private String summary;
    private Long maxPeopleNumber;
    private Long nowPeopleNumber;
    private List<String> roomCategory;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UserInfo owner;

    public RoomDto(Long id, String name, String summary, Long maxPeopleNumber, LocalDateTime createdAt, LocalDateTime updatedAt, Integer nowPeopleNumber, Long ownerId) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.maxPeopleNumber = maxPeopleNumber;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.nowPeopleNumber = nowPeopleNumber.longValue();
    }
}
