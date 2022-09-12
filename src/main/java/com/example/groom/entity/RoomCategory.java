package com.example.groom.entity;


import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
public class RoomCategory extends Category{

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
}
