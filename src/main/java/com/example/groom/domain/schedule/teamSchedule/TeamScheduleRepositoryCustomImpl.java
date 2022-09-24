package com.example.groom.domain.schedule.teamSchedule;

import com.example.groom.domain.schedule.teamSchedule.dto.TeamScheduleSearchCondition;
import com.example.groom.entity.domain.room.Room;
import com.example.groom.entity.domain.schedule.TeamSchedule;
import com.example.groom.entity.enums.RequestStatus;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

import static com.example.groom.entity.domain.schedule.QTeamSchedule.teamSchedule;
import static com.example.groom.entity.domain.schedule.QTeamScheduleUser.teamScheduleUser;

public class TeamScheduleRepositoryCustomImpl implements TeamScheduleRepositoryCustom {

    private final JPAQueryFactory query;

    @Autowired
    private EntityManager em;

    public TeamScheduleRepositoryCustomImpl(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public Page<TeamSchedule> searchByCondition(Pageable pageable, TeamScheduleSearchCondition teamScheduleSearchCondition) {
        List<TeamSchedule> teamScheduleList = query
                .selectFrom(teamSchedule)
                .where(eqRoom(teamScheduleSearchCondition.getRoom()),
                        betweenScheduleTime(teamScheduleSearchCondition.getStartTime(), teamScheduleSearchCondition.getEndTime()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        int size = query
                .selectFrom(teamSchedule)
                .where(eqRoom(teamScheduleSearchCondition.getRoom()),
                        betweenScheduleTime(teamScheduleSearchCondition.getStartTime(), teamScheduleSearchCondition.getEndTime()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch().size();

        return new PageImpl<>(teamScheduleList, pageable, size);
    }

    @Override
    public void updateParticipation(Long teamScheduleId, Long userId, RequestStatus status) {
        query.update(teamScheduleUser)
                .set(teamScheduleUser.status, status)
                .where(teamScheduleUser.id.eq(teamScheduleId), teamScheduleUser.participant.id.eq(userId))
                .execute();
    }

    @Override
    public Page<TeamSchedule> searchByUserId(Pageable pageable, Long userId) {
        List<TeamSchedule> teamScheduleList = query
                .selectFrom(teamSchedule)
                .where(teamScheduleUser.participant.id.eq(userId))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        int size = query
                .selectFrom(teamSchedule)
                .where(teamScheduleUser.participant.id.eq(userId))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch().size();

        return new PageImpl<>(teamScheduleList, pageable, size);
    }

    private BooleanExpression eqRoom(Room room) {
        return teamSchedule.room.eq(room);
    }

    private BooleanExpression betweenScheduleTime(LocalDateTime startTime, LocalDateTime endTime) {
        if (startTime == null) {
            return null;
        }
        if (endTime == null) {
            return null;
        }

        return teamSchedule.startTime.between(startTime, endTime)
                .or(teamSchedule.endTime.between(startTime, endTime));
    }
}
