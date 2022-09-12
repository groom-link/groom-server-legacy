package com.example.groom.entity;


import com.example.groom.domain.todo.Dto.TodoDto;
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
        this.todoOwner = todoDto.getTodoOwner();
        this.roomSlot = todoDto.getRoomSlot();
    }
}
