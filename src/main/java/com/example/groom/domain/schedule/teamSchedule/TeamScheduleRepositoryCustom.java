package com.example.groom.domain.schedule.teamSchedule;

import com.example.groom.domain.schedule.teamSchedule.dto.TeamScheduleSearchCondition;
import com.example.groom.entity.domain.schedule.TeamSchedule;
import com.example.groom.entity.enums.RequestStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeamScheduleRepositoryCustom {

    // 팀의 스케줄 목록 가져오기
    Page<TeamSchedule> searchByCondition(Pageable pageable, TeamScheduleSearchCondition teamScheduleSearchCondition);

    // 특정 팀스케줄의 참가여부 수정
    void updateParticipation(Long teamScheduleId, Long userId, RequestStatus status);

}
