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
public class TodoAttachment extends CoopEntity {

    @Column
    private String name;

    @Column
    private String explain;

    @JoinColumn(name = "file_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private File file;

    @JoinColumn(name = "todo_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Todo todo;
}