package org.simbirsoft.dashboard.user.service;

import org.simbirsoft.dashboard.user.entity.User;
import org.simbirsoft.dashboard.user.entity.dto.UserResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    void save(User user);

    List<UserResponseDto> getAll(Pageable pageable);

    UserResponseDto getById(Long id);

    void delete(Long id);

    UserResponseDto updateUser(User user);

    User me();

    User findByUsername(String name);
}
