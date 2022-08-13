package com.example.groom.entity;


import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Room extends OwnEntity{
    @Column
    private String name;

//    @JoinColumn
//    @ManyToOne(fetch = FetchType.LAZY)
//    private RoomCategory category;
}
