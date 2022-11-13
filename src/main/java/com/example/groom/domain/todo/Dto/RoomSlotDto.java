package com.example.groom.domain.todo.Dto;

import com.example.groom.entity.enums.RoomSlotSample;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoomSlotDto {

    private Long id;

    private RoomSlotSample roomSlot;
}
