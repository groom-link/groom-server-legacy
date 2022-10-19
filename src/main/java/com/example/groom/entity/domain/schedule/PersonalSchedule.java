package com.example.groom.entity.domain.schedule;

import com.example.groom.domain.schedule.dto.ScheduleDto;
import com.example.groom.domain.schedule.personalSchedule.dto.PersonalScheduleDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Entity
@DiscriminatorValue(value = "PERSONAL_SCHEDULE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PersonalSchedule extends Schedule {

    protected PersonalSchedule(PersonalScheduleDto personalScheduleDto) {
        super(new ScheduleDto(personalScheduleDto.getStartTime(), personalScheduleDto.getEndTime(), personalScheduleDto.getTitle()));
    }

    public PersonalSchedule(Long id) {
        super(id);
    }

    static public PersonalSchedule of(PersonalScheduleDto personalScheduleDto) {
        return new PersonalSchedule(personalScheduleDto);
    }
}
