package com.example.groom.domain.todo.Dto;

import com.example.groom.entity.Room;
import com.example.groom.entity.RoomSlot;
import com.example.groom.entity.TodoBox;
import com.example.groom.entity.UserInfo;
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
