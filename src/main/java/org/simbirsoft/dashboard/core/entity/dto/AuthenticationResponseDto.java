package org.simbirsoft.dashboard.core.entity.dto;


import org.simbirsoft.dashboard.user.entity.dto.UserResponseDto;

public class  AuthenticationResponseDto {

    UserResponseDto user;
    String token;

    public AuthenticationResponseDto(UserResponseDto user, String token) {
        this.user = user;
        this.token = token;
    }

    public UserResponseDto getUser() {
        return user;
    }

    public void setUser(UserResponseDto user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
