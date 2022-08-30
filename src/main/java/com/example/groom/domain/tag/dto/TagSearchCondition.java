package com.example.groom.domain.tag.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TagSearchCondition {
    private String name;
    private LocalDateTime dateLoe;
    private LocalDateTime dateGoe;

    public TagSearchCondition(String name, LocalDateTime dateLoe, LocalDateTime dateGoe) {
        this.name = name;
        this.dateLoe = dateLoe;
        this.dateGoe = dateGoe;
    }
}
