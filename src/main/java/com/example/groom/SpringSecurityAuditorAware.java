package com.example.groom;


import com.example.groom.domain.auth.UserInfo.UserInfoService;
import com.example.groom.entity.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
@RequiredArgsConstructor
public class SpringSecurityAuditorAware implements AuditorAware<UserInfo> {
    private final UserInfoService userInfoService;

    @Override
    public Optional<UserInfo> getCurrentAuditor() {
        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .map(authentication -> userInfoService.getUserInfo((Long) authentication.getDetails()));
    }
}