package com.example.groom.domain.todo.Dto;

import lombok.Data;

@Data
public class TodoListDto {

    private Long id;

    private String title;

    private String content;

    private String nickname;

    private String profileImage;

    private Long roomSlotId;

    private Long todoBoxId;
}
