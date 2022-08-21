package com.example.groom.entity;


import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
public class RoomTag extends BaseEntity{
    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Tag tag;
}
