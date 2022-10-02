package com.example.groom.domain.todo.Dto;

import com.example.groom.entity.TodoBox;
import lombok.Data;

@Data
public class TodoDto {

    private String title;

    private String content;
    
    private TodoBox todoBox;

    private Long todoOwnerId;

    private Long roomSlotId;

    private Long roomId;
}
