package com.example.groom.entity;

import com.example.groom.entity.common.CoopEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Evaluation extends CoopEntity {

    @Column
    private String content;

    @Column
    private String score;

    @JoinColumn(name = "todo_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Todo todo; // 평가 받는 Todo
}
