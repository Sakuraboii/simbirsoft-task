package org.simbirsoft.dashboard.core.security.jwt;


import org.simbirsoft.dashboard.core.configuration.RestAuthenticationEntryPoint;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


public class JwtConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private JwtTokenProvider jwtTokenProvider;
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    public JwtConfigurer(JwtTokenProvider jwtTokenProvider, RestAuthenticationEntryPoint restAuthenticationEntryPoint) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
    }

    @Override
    public void configure(HttpSecurity httpSecurity) {
        JwtTokenFilter jwtTokenFilter = new JwtTokenFilter(jwtTokenProvider, restAuthenticationEntryPoint);
        httpSecurity.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
}