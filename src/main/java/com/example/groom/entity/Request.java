package com.example.groom.entity;

import com.example.groom.entity.enums.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Request_Type")
public abstract class Request extends CoopEntity{

    @Column
    private String content;

    @Column
    private LocalDateTime due_date;

    @Column
    private RequestStatus request_status;

//    @JoinColumn
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Long roomid;//bigint [ref: > room.id]

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Todo todo;
}