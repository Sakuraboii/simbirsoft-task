package org.simbirsoft.dashboard.user.controller;

import org.simbirsoft.dashboard.user.entity.User;
import org.simbirsoft.dashboard.user.entity.dto.UserResponseDto;
import org.simbirsoft.dashboard.user.mapper.UserMapper;
import org.simbirsoft.dashboard.user.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(org.simbirsoft.dashboard.core.urls.User.user)
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper){
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @PostMapping
    public void save(@RequestBody User user){
        userService.save(user);
    }

    @GetMapping("/all")
    public List<UserResponseDto> getAll(Pageable pageable){
        return userMapper.fromEntities(userService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public UserResponseDto getById(@PathVariable String id){
        return userMapper.fromEntity(userService.getById(id));
    }

    @DeleteMapping
    public void deleteUser(String id){
        userService.delete(id);
    }

    @PutMapping
    public void updateUser(User user){
        userService.updateUser(user);
    }
}
