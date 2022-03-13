package org.simbirsoft.dashboard.core.service.impl;

import org.simbirsoft.dashboard.core.entity.dto.UserCreationDto;
import org.simbirsoft.dashboard.core.repostitory.RoleRepository;
import org.simbirsoft.dashboard.core.security.Authorities;
import org.simbirsoft.dashboard.core.service.AccountService;
import org.simbirsoft.dashboard.user.entity.User;
import org.simbirsoft.dashboard.user.mapper.UserMapper;
import org.simbirsoft.dashboard.user.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public AccountServiceImpl(UserRepository userRepository,
                              RoleRepository roleRepository,
                              PasswordEncoder passwordEncoder,
                              UserMapper userMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    public User register(UserCreationDto userCreationDto) {
        User user = userMapper.fromDto(userCreationDto);

        user.addRole(roleRepository.findByName(Authorities.ROLE_USER).orElseThrow(() ->
                new RuntimeException(String.format("Can't find role with name %s", Authorities.ROLE_USER))));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User me() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username);
    }

}
