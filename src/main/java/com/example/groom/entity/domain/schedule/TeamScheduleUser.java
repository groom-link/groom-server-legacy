package com.example.groom.entity.domain.schedule;

import com.example.groom.entity.common.BaseEntity;
import com.example.groom.entity.domain.auth.UserInfo;
import com.example.groom.entity.enums.RequestStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class TeamScheduleUser extends BaseEntity {

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private TeamSchedule teamSchedule;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo participant;

    @Column
    @Enumerated(EnumType.STRING)
    private RequestStatus status;
}
