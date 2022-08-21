package com.example.groom.domain.auth.dto;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class KakaoTokenValidationDto {
    private Long id;
    private Integer expiresIn;
    private Integer appId;
}
