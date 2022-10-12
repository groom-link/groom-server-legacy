package com.example.groom.domain.schedule.teamSchedule;

import com.example.groom.domain.schedule.teamSchedule.dto.TeamScheduleSearchCondition;
import com.example.groom.entity.domain.schedule.TeamSchedule;
import com.example.groom.entity.enums.RequestStatus;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;

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
    public Slice<TeamSchedule> searchByCondition(Pageable pageable, TeamScheduleSearchCondition teamScheduleSearchCondition) {
        List<TeamSchedule> content = query
                .selectFrom(teamSchedule)
                .where(teamScheduleUser.participant.id.eq(teamScheduleSearchCondition.getUserId()),
                        betweenScheduleTime(teamScheduleSearchCondition.getStartTime(), teamScheduleSearchCondition.getEndTime()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        int size = query
                .selectFrom(teamSchedule)
                .where(teamScheduleUser.participant.id.eq(teamScheduleSearchCondition.getUserId()),
                        betweenScheduleTime(teamScheduleSearchCondition.getStartTime(), teamScheduleSearchCondition.getEndTime()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch().size();

        boolean hasNext = getHasNext(content, pageable);

        return new SliceImpl<>(content, pageable, hasNext);
    }

    @Override
    public void updateParticipation(Long teamScheduleId, Long userId, RequestStatus status) {
        query.update(teamScheduleUser)
                .set(teamScheduleUser.status, status)
                .where(teamScheduleUser.id.eq(teamScheduleId), teamScheduleUser.participant.id.eq(userId))
                .execute();
    }

    @Override
    public List<Long> getParticipants(Long teamScheduleId) {
        return query.select(teamScheduleUser.participant.id)
                .from(teamScheduleUser)
                .where(teamScheduleUser.teamSchedule.id.eq(teamScheduleId))
                .fetch();
    }

    private <T> boolean getHasNext(List<T> content, Pageable pageable) {
        boolean hasNext = false;
        if (content.size() > pageable.getPageSize()) {
            content.remove(pageable.getPageSize());
            hasNext = true;
        }
        return hasNext;
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
