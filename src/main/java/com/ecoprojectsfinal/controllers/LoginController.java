package com.ecoprojectsfinal.controllers;

import com.ecoprojectsfinal.dtos.loginDto.LoginRequestDto;
import com.ecoprojectsfinal.dtos.loginDto.LoginResponseDto;
import com.ecoprojectsfinal.services.loginServices.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("loginDto")
public class LoginController {

    private final LoginService service;

    @PostMapping
    public LoginResponseDto login(@RequestBody LoginRequestDto dto) {
        return service.authenticate(dto);
    }

}