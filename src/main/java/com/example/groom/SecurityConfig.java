package com.example.groom;

import com.example.groom.common.auth.JwtAuthenticateFilter;
import com.example.groom.domain.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public JwtAuthenticateFilter jwtAuthenticateFilter(){
        return new JwtAuthenticateFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private AuthService authService;
    private static final String[] PUBLIC_URI = {
            "/auth/**","/swagger-ui/**", "/v3/**", "/api-docs","/**", "/auth/me"
    };

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                // 개발 편의성을 위해 CSRF 프로텍션을 비활성화
                .csrf()
                .disable()
                // HTTP 기본 인증 비활성화
                .httpBasic()
                .disable()
                // 폼 기반 인증 비활성화
                .formLogin()
                .disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // stateless한 세션 정책 설정
        // 리소스 별 허용 범위 설정
        http
                .authorizeRequests()
                .antMatchers(PUBLIC_URI)
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(authService)
                .and().permitAll();


        return http.build();
    }


}

