package com.example.groom.domain.room;

import com.example.groom.domain.auth.userInfo.dto.UserInfoDto;
import com.example.groom.domain.category.dto.CategoryDto;
import com.example.groom.domain.room.dto.RoomDetailDto;
import com.example.groom.domain.room.dto.RoomListDto;
import com.example.groom.domain.room.dto.RoomSearchCondition;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.util.List;

import static com.example.groom.entity.domain.auth.QUserInfo.userInfo;
import static com.example.groom.entity.domain.room.QRoom.room;
import static com.example.groom.entity.domain.room.QRoomCategory.roomCategory;
import static com.example.groom.entity.domain.room.QRoomParticipants.roomParticipants;


public class RoomRepositoryImpl implements RoomRepositoryCustom {

    @Autowired
    private EntityManager em;

    private final JPAQueryFactory query;

    public RoomRepositoryImpl(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

    private JPAQuery<RoomListDto> getRoomListDtoSelect() {
        return query
                .select(Projections.constructor(RoomListDto.class,
                        room.id,
                        room.name,
                        Projections.constructor(CategoryDto.class, room.category),
                        room.maxPeople,
                        room.createdAt,
                        room.updatedAt,
                        ExpressionUtils.as(
                                JPAExpressions.select(roomParticipants.count())
                                        .from(roomParticipants)
                                        .where(roomParticipants.room.id.eq(room.id)),
                                "nowPeople"
                        ),
                        //TODO 스케쥴 불러오기
                        //TODO 할일 개수 불러오기
                        Projections.constructor(UserInfoDto.class, room.owner)
                ))
                .from(room)
                .leftJoin(room.owner, userInfo)
                .fetchJoin()
                .leftJoin(room.category, roomCategory)
                .fetchJoin();
    }

    private JPAQuery<RoomDetailDto> getRoomDetailDtoSelect() {
        return query
                .select(Projections.constructor
                        (RoomDetailDto.class,
                                room.id,
                                room.name,
                                Projections.constructor(CategoryDto.class, room.category),
                                room.description,
                                room.mainImageUrl,
                                room.summary,
                                ExpressionUtils.as(
                                        JPAExpressions.select(Projections.constructor(UserInfoDto.class
                                        ,roomParticipants.userInfo
                                                )),"roomParticipants")
                                ))
                .from(room)
                .leftJoin(room.category, roomCategory)
                .fetchJoin()
                .leftJoin(room.roomParticipants, roomParticipants)
                .fetchJoin();
    }

    @Override
    public RoomDetailDto getRoomDetailDtoByRoomId(Long id) {
        RoomDetailDto roomDetailDto = this.getRoomDetailDtoSelect()
                .from(room)
                .where(room.id.eq(id))
                .fetchOne();
        return roomDetailDto;
    }

    @Override
    public Page<RoomListDto> searchByCondition(Pageable pageable, RoomSearchCondition condition) {
        List<RoomListDto> roomDtos = this.getRoomListDtoSelect()
                .where(condition.getCondition())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        int size = query
                .selectFrom(room)
                .where(condition.getCondition())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch()
                .size();
        return new PageImpl<>(roomDtos, pageable, size);
    }
}
