package org.simbirsoft.dashboard.core.service;


import org.simbirsoft.dashboard.core.entity.dto.UserCreationDto;
import org.simbirsoft.dashboard.user.entity.User;

public interface AccountService {
    User register(UserCreationDto user);

    User me();
}
