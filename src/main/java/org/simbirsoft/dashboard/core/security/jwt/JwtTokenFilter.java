package org.simbirsoft.dashboard.core.security.jwt;


import liquibase.repackaged.org.apache.commons.lang3.StringUtils;
import org.simbirsoft.dashboard.core.configuration.RestAuthenticationEntryPoint;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenFilter extends OncePerRequestFilter {

    private JwtTokenProvider jwtTokenProvider;

    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider, RestAuthenticationEntryPoint restAuthenticationEntryPoint) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            String token = jwtTokenProvider.resolveToken(request);

            if (StringUtils.isNotEmpty(token) && jwtTokenProvider.validateToken(token)) {
                Authentication authentication = jwtTokenProvider.getAuthentication(token);

                if (authentication != null) {
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
            chain.doFilter(request, response);
        } catch (AuthenticationException exception) {
            restAuthenticationEntryPoint.commence(request, response, exception);
        }
    }
}
