package com.example.groom.domain.schedule;

import com.example.groom.common.exception.CustomException;
import com.example.groom.common.exception.ErrorCode;
import com.example.groom.domain.schedule.dto.ScheduleDto;
import com.example.groom.domain.schedule.dto.ScheduleSearchCondition;
import com.example.groom.entity.domain.schedule.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public void deleteSchedule(Long id) {
        if (scheduleRepository.existsById(id)) {
            scheduleRepository.deleteById(id);
        } else {
            throw new CustomException(ErrorCode.SCHEDULE_NOT_FOUND);
        }
    }

    public Page<Schedule> searchSchedule(Pageable pageable, ScheduleSearchCondition scheduleSearchCondition) {
        return this.scheduleRepository.searchByCondition(pageable, scheduleSearchCondition);
    }
}
