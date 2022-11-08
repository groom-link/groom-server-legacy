package com.example.groom.domain.todo.Dto;

import com.example.groom.domain.auth.userInfo.dto.TodoUserInfoDto;
import com.example.groom.entity.domain.auth.UserInfo;
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

    private String fileUrl;

    private RoomSlotSample roomSlot;

    private TodoUserInfoDto todoOwner;

    public static TodoDetailDto of(Todo todo, UserInfo todoOwner) {
        return TodoDetailDto.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .content(todo.getContent())
                .fileUrl(todo.getFileUrl())
                .roomSlot(todo.getRoomSlot())
                .todoOwner(TodoUserInfoDto.of(todoOwner))
                .build();
    }

    public static TodoDetailDto of(Todo todo) {
        return TodoDetailDto.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .content(todo.getContent())
                .fileUrl(todo.getFileUrl())
                .roomSlot(todo.getRoomSlot())
                .todoOwner(TodoUserInfoDto.of(todo.getTodoOwner()))
                .build();
    }
}