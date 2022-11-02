package com.example.groom.domain.schedule.teamSchedule;

import com.example.groom.domain.schedule.dto.ScheduleDto;
import com.example.groom.domain.schedule.teamSchedule.dto.TeamScheduleSearchCondition;
import com.example.groom.entity.domain.schedule.TeamSchedule;
import com.example.groom.entity.enums.RequestStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface TeamScheduleRepositoryCustom {

    // 팀의 스케줄 목록 가져오기
    Slice<TeamSchedule> searchByCondition(Pageable pageable, TeamScheduleSearchCondition teamScheduleSearchCondition);

    // 특정 팀스케줄의 참가여부 수정
    void updateParticipation(Long teamScheduleId, Long userId, RequestStatus status);

    // 특정 팀스케줄의 참가자 목록 가져오기
    List<Long> getParticipants(Long teamScheduleId);

    List<ScheduleDto> searchByCondition(TeamScheduleSearchCondition teamScheduleSearchCondition);

}
