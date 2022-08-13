package com.example.groom.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoomSlot extends CoopEntity {

    @Column
    private String colorHex;

    @Column
    private String name;

    @Column
    private Long order;

//    @JoinColumn
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Long room_id;
}
