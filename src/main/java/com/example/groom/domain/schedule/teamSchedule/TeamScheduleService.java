package com.example.groom.domain.schedule.teamSchedule;

import com.example.groom.domain.schedule.teamSchedule.dto.TeamScheduleDto;
import com.example.groom.entity.domain.schedule.TeamSchedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamScheduleService {

    private final TeamScheduleRepository teamScheduleRepository;

    public TeamSchedule createTeamSchedule(TeamScheduleDto teamScheduleDto) {
        TeamSchedule teamSchedule = TeamSchedule.of(teamScheduleDto);

        teamScheduleRepository.save(teamSchedule);

        return teamSchedule;
    }
}
