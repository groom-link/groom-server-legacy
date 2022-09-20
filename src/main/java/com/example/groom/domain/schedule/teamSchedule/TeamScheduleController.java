package com.example.groom.domain.schedule.teamSchedule;

import com.example.groom.domain.schedule.teamSchedule.dto.TeamScheduleDto;
import com.example.groom.entity.domain.schedule.TeamSchedule;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/team-schedule")
public class TeamScheduleController {

    private final TeamScheduleService teamScheduleService;

    @PostMapping
    public TeamSchedule postTeamSchedule(@RequestBody TeamScheduleDto teamScheduleDto) {
        return teamScheduleService.createTeamSchedule(teamScheduleDto);
    }

    @DeleteMapping("/{id}")
    public Long deleteSchedule(@PathVariable Long id) {

        teamScheduleService.deleteTeamSchedule(id);

        return id;
    }
}
