package org.simbirsoft.dashboard.user.service;

import org.simbirsoft.dashboard.user.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    void save(User user);

    List<User> getAll(Pageable pageable);

    User getById(String id);

    void delete(String id);

    void updateUser(User user);

    User me();

    User findByUsername(String name);
}
