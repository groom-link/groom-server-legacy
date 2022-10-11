package com.example.groom.domain.room.dto;


import com.example.groom.domain.auth.userInfo.dto.UserInfoDto;
import com.example.groom.domain.category.dto.CategoryDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoomListDto {
    private Long id;
    private String name;
    private String description;

    private String summary;
    private Long maxPeople;
    private Long nowPeople;
    private CategoryDto roomCategory;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public RoomListDto(Long id, String name, String description, Long maxPeople, Long nowPeople, CategoryDto roomCategory, LocalDateTime createdAt, LocalDateTime updatedAt, UserInfoDto owner) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.maxPeople = maxPeople;
        this.nowPeople = nowPeople;
        this.roomCategory = roomCategory;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.owner = owner;
    }

    private UserInfoDto owner;


}
