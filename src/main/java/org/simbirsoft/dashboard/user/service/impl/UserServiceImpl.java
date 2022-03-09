package org.simbirsoft.dashboard.user.service.impl;

import org.simbirsoft.dashboard.user.entity.User;
import org.simbirsoft.dashboard.user.entity.dto.UserResponseDto;
import org.simbirsoft.dashboard.user.mapper.UserMapper;
import org.simbirsoft.dashboard.user.repository.UserRepository;
import org.simbirsoft.dashboard.user.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository,
                           UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<UserResponseDto> getAll(Pageable pageable) {
        return userMapper.fromEntities(userRepository.findAll(pageable).getContent());
    }

    @Override
    public UserResponseDto getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            return userMapper.fromEntity(user.get());
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponseDto updateUser(User user) {
        User me = me();

        me.setPassword(user.getPassword() == null ? me.getPassword() : user.getPassword());
        me.setUsername(user.getUsername() == null ? me.getUsername() : user.getUsername());

        return userMapper.fromEntity(userRepository.save(me));
    }

    @Override
    public User me() {
        return findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @Override
    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }
}
