package com.example.groom.domain.auth.UserInfo;

import com.example.groom.entity.KakaoInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KakaoInfoRepository extends JpaRepository<KakaoInfo, Long> {

}
