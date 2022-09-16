package com.example.groom.domain.room.dto;


import com.example.groom.entity.domain.auth.UserInfo;
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

    private List<String> category;

    private String description;

    private String mainImageUrl;

    private List<String> descriptionImageUrls;

    private String summary;

    private List<UserInfo> roomParticipants = new ArrayList<>();

    public RoomDetailDto(Long id, String name, String summary, String description, String mainImageUrl, List<UserInfo> roomParticipants){
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.description = description;
        this.mainImageUrl = mainImageUrl;
        this.roomParticipants = roomParticipants;
    }

}
