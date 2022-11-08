package com.example.groom.domain.todo.Dto;

import com.example.groom.entity.domain.todo.Todo;
import com.example.groom.entity.enums.RoomSlotSample;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TodoDetailDto {

    private Long id;

    private String title;

    private String content;

    private Long todoOwnerId;

    private String nickname;

    private String profileImage;

    private String fileUrl;

    private RoomSlotSample roomSlot;

    public static TodoDetailDto of(Todo todo) {
        return TodoDetailDto.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .content(todo.getContent())
                .todoOwnerId(todo.getTodoOwner().getId())
                .nickname(todo.getTodoOwner().getKakao().getKakaoAccount().getProfile().getNickname())
                .profileImage(todo.getTodoOwner().getKakao().getKakaoAccount().getProfile().getProfileImageUrl())
                .fileUrl(todo.getFileUrl())
                .roomSlot(todo.getRoomSlot())
                .build();
    }

}