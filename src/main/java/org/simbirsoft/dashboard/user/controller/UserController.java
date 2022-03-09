package org.simbirsoft.dashboard.user.controller;

import org.simbirsoft.dashboard.user.entity.User;
import org.simbirsoft.dashboard.user.entity.dto.UserResponseDto;
import org.simbirsoft.dashboard.user.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(org.simbirsoft.dashboard.core.urls.User.USER)
public class UserController {

    private final UserService userService;


    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public void save(@RequestBody User user){
        userService.save(user);
    }

    @GetMapping(org.simbirsoft.dashboard.core.urls.User.All.ALL)
    public ResponseEntity<List<UserResponseDto>> getAll(Pageable pageable){
        return new ResponseEntity<>(userService.getAll(pageable), HttpStatus.OK);
    }

    @GetMapping(org.simbirsoft.dashboard.core.urls.User.Id.FULL)
    public ResponseEntity<UserResponseDto> getById(@PathVariable Long id){
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteUser(Long id){
        userService.delete(id);
    }

    @PutMapping
    public ResponseEntity<UserResponseDto> updateUser(User user){
        return new ResponseEntity<>(userService.updateUser(user),HttpStatus.OK);
    }
}
