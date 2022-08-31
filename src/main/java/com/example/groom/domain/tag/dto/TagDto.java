package com.example.groom.domain.tag.dto;

import lombok.Data;

@Data
public class TagDto {
    private Long id;

    private String name;

    private String colorHex;

    public TagDto(Long id, String name, String colorHex) {
        this.id = id;
        this.name = name;
        this.colorHex = colorHex;
    }
}
