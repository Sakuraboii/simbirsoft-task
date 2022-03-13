package org.simbirsoft.dashboard.core.service;


import org.simbirsoft.dashboard.core.entity.dto.AuthenticationRequestDto;
import org.simbirsoft.dashboard.core.entity.dto.AuthenticationResponseDto;

public interface AuthenticationService {
    AuthenticationResponseDto authenticate(AuthenticationRequestDto requestDto);
}
