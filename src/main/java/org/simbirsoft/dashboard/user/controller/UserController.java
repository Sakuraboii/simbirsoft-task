package org.simbirsoft.dashboard.user.controller;

import org.simbirsoft.dashboard.user.entity.User;
import org.simbirsoft.dashboard.user.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public void save(@RequestBody User user){
        userService.save(user);
    }

    @GetMapping("/all")
    public List<User> getAll(Pageable pageable){
        return userService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable String id){
        return userService.getById(id);
    }
}
