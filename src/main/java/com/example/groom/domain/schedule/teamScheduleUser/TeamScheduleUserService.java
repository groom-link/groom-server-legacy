package com.example.groom.domain.schedule.teamScheduleUser;

import com.example.groom.domain.schedule.teamScheduleUser.dto.TeamScheduleUserDto;
import com.example.groom.entity.domain.schedule.TeamScheduleUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamScheduleUserService {

    private final TeamScheduleUserRepository teamScheduleUserRepository;

    public void createTeamScheduleUser(TeamScheduleUserDto teamScheduleUserDto) {
        teamScheduleUserRepository.save(TeamScheduleUser.of(teamScheduleUserDto));
    }

}
