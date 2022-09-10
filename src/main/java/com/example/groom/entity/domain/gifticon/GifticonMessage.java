package com.example.groom.entity.domain.gifticon;

import com.example.groom.entity.common.OwnEntity;
import com.example.groom.entity.domain.auth.UserInfo;
import com.example.groom.entity.domain.room.Room;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
public class GifticonMessage extends OwnEntity {
    @JoinColumn
    @ManyToOne
    private UserInfo receiver;

    @Column
    private String message;

    @JoinColumn
    @ManyToOne
    private Gifticon gifticon;

    @JoinColumn
    @ManyToOne
    private Room room;
}
