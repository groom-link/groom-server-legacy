package com.example.groom.domain.schedule.unableSchedule;

import com.example.groom.domain.schedule.dto.ScheduleDto;
import com.example.groom.domain.schedule.unableSchedule.dto.UnableScheduleDto;
import com.example.groom.entity.domain.schedule.UnableSchedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnableScheduleService {

    private final UnableScheduleRepository unableScheduleRepository;

    public void createUnableSchedule(UnableScheduleDto unableScheduleDto) {
        UnableSchedule unableSchedule = UnableSchedule.of(unableScheduleDto);
        unableScheduleRepository.save(unableSchedule);
    }

    public List<ScheduleDto> searchUnableSchedule(Long roomId) {
        return unableScheduleRepository.findByRoomId(roomId);
    }

    public void deleteUnableSchedule(Long id) {
        unableScheduleRepository.deleteById(id);
    }
}
