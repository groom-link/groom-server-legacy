package com.example.groom.common.auth;

import com.example.groom.common.auth.jwt.JwtAuthentication;
import com.example.groom.common.auth.jwt.JwtAuthenticationTokenProvider;
import com.example.groom.common.auth.jwt.AuthenticationToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RequiredArgsConstructor
@Component
public class JwtAuthenticateFilter extends OncePerRequestFilter {
    private final JwtAuthenticationTokenProvider jwtAuthenticationTokenProvider;

    private Authentication getAuthentication(String token){
        Jws<Claims> claimsJws = jwtAuthenticationTokenProvider.validateAccessToken(token);
        return new JwtAuthentication(Long.valueOf(claimsJws.getBody().getAudience()));

    }
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        AuthenticationToken token = jwtAuthenticationTokenProvider.getTokenFromHeader(request);
        if(token.getAccessToken() == null){
            filterChain.doFilter(request,response);
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(getAuthentication(token.getAccessToken()));
        filterChain.doFilter(request,response);
    }
}
