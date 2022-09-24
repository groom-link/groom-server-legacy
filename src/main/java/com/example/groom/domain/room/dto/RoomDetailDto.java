package com.example.groom.domain.room.dto;


import com.example.groom.domain.auth.userInfo.dto.UserInfoDto;
import com.example.groom.domain.category.dto.CategoryDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoomDetailDto {
    private Long id;
    private String name;

    private CategoryDto category;
    private String description;

    private String mainImageUrl;

    private String summary;

    private List<UserInfoDto> roomParticipants = new ArrayList<>();


    public RoomDetailDto(Long id, String name, CategoryDto category, String description, String mainImageUrl, String summary, List<UserInfoDto> roomParticipants) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.mainImageUrl = mainImageUrl;
        this.summary = summary;
        this.roomParticipants = roomParticipants;
    }
}
