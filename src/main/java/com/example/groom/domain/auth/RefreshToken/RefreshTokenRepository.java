package com.example.groom.domain.auth.RefreshToken;

import com.example.groom.common.customRepository.RefreshTokenRepositoryCustom;
import com.example.groom.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>, RefreshTokenRepositoryCustom {

}
