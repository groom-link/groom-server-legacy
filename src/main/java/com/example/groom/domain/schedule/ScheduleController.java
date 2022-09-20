package com.example.groom.domain.schedule;

import com.example.groom.domain.schedule.dto.ScheduleDto;
import com.example.groom.entity.domain.schedule.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public Schedule postSchedule(@RequestBody ScheduleDto scheduleDto) {
        return scheduleService.createSchedule(scheduleDto);
    }

    @DeleteMapping("/{id}")
    public Long deleteSchedule(@PathVariable Long id) {

        scheduleService.deleteSchedule(id);

        return id;
    }
}
