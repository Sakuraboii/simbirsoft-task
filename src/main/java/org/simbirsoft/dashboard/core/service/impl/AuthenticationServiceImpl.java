package org.simbirsoft.dashboard.core.service.impl;


import org.simbirsoft.dashboard.core.entity.dto.AuthenticationRequestDto;
import org.simbirsoft.dashboard.core.entity.dto.AuthenticationResponseDto;
import org.simbirsoft.dashboard.core.security.jwt.JwtTokenProvider;
import org.simbirsoft.dashboard.core.service.AuthenticationService;
import org.simbirsoft.dashboard.user.entity.User;
import org.simbirsoft.dashboard.user.mapper.UserMapper;
import org.simbirsoft.dashboard.user.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    final private AuthenticationManager authenticationManager;
    final private UserService userService;
    final private UserMapper userMapper;
    final private JwtTokenProvider jwtTokenProvider;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager,
                                     UserService userService,
                                     UserMapper userMapper,
                                     JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.userMapper = userMapper;
        this.jwtTokenProvider = jwtTokenProvider;

    }

    @Override
    public AuthenticationResponseDto authenticate(AuthenticationRequestDto requestDto) {
        try {
            String username = requestDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));

            User user = userService.findByUsername(username);
            String token = jwtTokenProvider.createToken(user);
            return new AuthenticationResponseDto(userMapper.fromEntity(user), token);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }
}
