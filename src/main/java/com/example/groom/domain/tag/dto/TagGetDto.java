package com.example.groom.domain.tag.dto;

import lombok.Data;

import java.util.List;


@Data
public class TagGetDto {
    private Long id;
    private String name;
    private String summary;
    private List<String> category;
    private String colorHex;

    public TagGetDto(Long id, String name, String summary, List<String> category, String colorHex) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.category = category;
        this.colorHex = colorHex;
    }
}
