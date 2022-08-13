package com.example.groom.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
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

    @JoinColumn(name = "todoBox_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private TodoBox todoBox;

    @JoinColumn(name = "userInfo_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo userInfo;

//    @JoinColumn
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Long room_id;

    @Builder
    public UpdateTodo(String title, String content, TodoBox todoBox, UserInfo userInfo) {
        this.title = title;
        this.content = content;
        this.todoBox = todoBox;
        this.userInfo = userInfo;
    }
}
