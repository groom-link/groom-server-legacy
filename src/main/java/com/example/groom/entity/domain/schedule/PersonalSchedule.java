package com.example.groom.entity.domain.schedule;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Entity
@DiscriminatorValue(value = "PERSONAL_SCHEDULE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PersonalSchedule extends Schedule {

    @Column
    private String title;

    protected PersonalSchedule(String title) {
        this.title = title;
    }

    public PersonalSchedule(Long id) {
        super(id);
    }

    static public PersonalSchedule of(String title) {
        return new PersonalSchedule(title);
    }
}
