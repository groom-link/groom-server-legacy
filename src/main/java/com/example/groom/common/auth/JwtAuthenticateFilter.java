package com.example.groom.common.auth;

import com.example.groom.common.auth.jwt.AuthenticationToken;
import com.example.groom.common.auth.jwt.JwtAuthentication;
import com.example.groom.common.auth.jwt.JwtAuthenticationTokenProvider;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.RequiredArgsConstructor;
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

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        AuthenticationToken token = jwtAuthenticationTokenProvider.getTokenFromHeader(request);
        Jws<Claims> claimsJws = jwtAuthenticationTokenProvider.validateToken(token.getAccessToken());
        SecurityContextHolder.getContext().setAuthentication(new JwtAuthentication(claimsJws));
        filterChain.doFilter(request,response);
    }
}
