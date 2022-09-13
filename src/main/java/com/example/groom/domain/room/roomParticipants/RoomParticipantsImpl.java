package com.example.groom.domain.room.roomParticipants;

import com.example.groom.entity.domain.auth.UserInfo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

import static com.example.groom.entity.domain.auth.QKakaoInfo.kakaoInfo;
import static com.example.groom.entity.domain.auth.QUserInfo.userInfo;
import static com.example.groom.entity.domain.room.QRoomParticipants.roomParticipants;


public class RoomParticipantsImpl implements RoomParticipantsCustom {

    @Autowired
    private EntityManager em;

    private final JPAQueryFactory query;

    public RoomParticipantsImpl(EntityManager em){this.query = new JPAQueryFactory(em);}


    @Override
    public List<UserInfo> getParticipantsListUserInfosByRoomId(Long roomId) {
        List<UserInfo> userInfos = query
                .select(roomParticipants.userInfo)
                .from(roomParticipants)
                .leftJoin(roomParticipants.userInfo, userInfo)
                .fetchJoin()
                .leftJoin(roomParticipants.userInfo.kakao, kakaoInfo)
                .fetchJoin()
                .where(roomParticipants.room.id.eq(roomId))
                .fetch();
        return userInfos;
    }

    @Override
    public Long countParticipantsByRoomId(Long roomId) {
        return Long.valueOf(query.selectFrom(roomParticipants)
                .where(roomParticipants.room.id.eq(roomId))
                .fetch().size());
    }
}
