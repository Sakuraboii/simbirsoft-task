package org.simbirsoft.dashboard.user.mapper;

import org.simbirsoft.dashboard.core.entity.dto.UserCreationDto;
import org.simbirsoft.dashboard.user.entity.User;
import org.simbirsoft.dashboard.user.entity.dto.UserResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public UserResponseDto fromEntity(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setUsername(user.getUsername());

        return userResponseDto;
    }

    public List<UserResponseDto> fromEntities(List<User> users) {

        List<UserResponseDto> userResponseDtos = new ArrayList<>();

        for (User user : users) {
            userResponseDtos.add(fromEntity(user));
        }

        return userResponseDtos;
    }

    public User fromDto(UserCreationDto userCreationDto) {
        return new User(userCreationDto.getUsername(), userCreationDto.getPassword());
    }
}
