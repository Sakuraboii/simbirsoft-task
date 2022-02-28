package org.simbirsoft.dashboard.user.service.impl;

import org.simbirsoft.dashboard.user.entity.User;
import org.simbirsoft.dashboard.user.repository.UserRepository;
import org.simbirsoft.dashboard.user.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable).getContent();
    }

    @Override
    public User getById(String id) {
        Optional<User> user =  userRepository.findById(id);
        return user.orElse(null);
    }
}
