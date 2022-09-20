package com.example.groom.domain.schedule;

import com.example.groom.domain.schedule.dto.ScheduleDto;
import com.example.groom.entity.domain.schedule.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public Schedule createSchedule(ScheduleDto scheduleDto) {
        Schedule schedule = Schedule.of(scheduleDto);

        scheduleRepository.save(schedule);

        return schedule;
    }
}
