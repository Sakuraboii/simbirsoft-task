package org.simbirsoft.dashboard.core.controller;


import org.simbirsoft.dashboard.core.entity.dto.AuthenticationRequestDto;
import org.simbirsoft.dashboard.core.entity.dto.AuthenticationResponseDto;
import org.simbirsoft.dashboard.core.entity.dto.UserCreationDto;
import org.simbirsoft.dashboard.core.service.AccountService;
import org.simbirsoft.dashboard.core.service.AuthenticationService;
import org.simbirsoft.dashboard.user.entity.dto.UserResponseDto;
import org.simbirsoft.dashboard.user.mapper.UserMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    public AccountController(AuthenticationService authenticationService,
                             AccountService accountService,
                             UserMapper userMapper) {
        this.authenticationService = authenticationService;
        this.accountService = accountService;
        this.userMapper = userMapper;
    }

    private final AuthenticationService authenticationService;
    private final AccountService accountService;
    private final UserMapper userMapper;


    @PostMapping("/sign-up")
    public UserResponseDto createUser(@RequestBody @Validated UserCreationDto userCreationDto) {
        return userMapper.fromEntity(accountService.register(userCreationDto));
    }


    @PostMapping("/sign-in")
    public ResponseEntity<AuthenticationResponseDto> login(@RequestBody @Validated AuthenticationRequestDto requestDto) {
        return ResponseEntity.ok(authenticationService.authenticate(requestDto));
    }

}
