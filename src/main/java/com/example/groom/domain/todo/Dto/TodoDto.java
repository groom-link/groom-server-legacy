package com.example.groom.domain.todo.Dto;

import lombok.Data;

@Data
public class TodoDto {

    private String title;

    private String content;

    private Long todoOwnerId;

    private Long roomId;
}
