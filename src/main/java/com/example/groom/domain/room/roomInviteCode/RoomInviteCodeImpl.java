package com.example.groom.domain.room.roomInviteCode;

import com.example.groom.domain.room.roomInviteCode.dto.CodeDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class RoomInviteCodeImpl implements RoomInviteCodeCustom {

    @Autowired
    private EntityManager em;

    private final JPAQueryFactory query;

    public RoomInviteCodeImpl(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public CodeDto findByRoomId(Long roomId) {
//        query.select(Projections.constructor(CodeDto.class, roomInviteCode.code)).from(roomInviteCode).where(roomInviteCode.room.id.eq(roomId)).fetchOne()
        return null;
    }
}
