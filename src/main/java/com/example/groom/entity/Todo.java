package com.example.groom.entity;


import com.example.groom.domain.todo.Dto.TodoDto;
import com.example.groom.entity.common.CoopEntity;
import com.example.groom.entity.domain.auth.UserInfo;
import com.example.groom.entity.domain.room.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Todo extends CoopEntity {

    @Column
    private String title;

    @Column
    private String content;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private TodoBox todoBox;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo todoOwner;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private RoomSlot roomSlot;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;

    public void updateTodo(TodoDto todoDto) {
        this.title = todoDto.getTitle();
        this.content = todoDto.getContent();
        this.todoBox = todoDto.getTodoBox();
        this.todoOwner = UserInfo.of(todoDto.getTodoOwnerId());
        this.roomSlot = RoomSlot.of(todoDto.getRoomSlotId());
    }
}
