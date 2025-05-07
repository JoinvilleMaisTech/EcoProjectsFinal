package com.ecoprojectsfinal.services.loginServices;

import com.ecoprojectsfinal.dtos.loginDto.LoginRequestDto;
import com.ecoprojectsfinal.dtos.loginDto.LoginResponseDto;
import com.ecoprojectsfinal.services.userServices.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final PasswordEncoder encoder;
    private final UserService userService;

    @Override
    public LoginResponseDto authenticate(LoginRequestDto dto) {
        UserDetails user = userService.loadUserByUsername(dto.getUsername());
        if (!encoder.matches(dto.getPassword(), user.getPassword())) {
            throw new UsernameNotFoundException(user.getUsername());
        }

        String token = dto.getUsername() + ":" + dto.getPassword();
        token = Base64.getEncoder().encodeToString(token.getBytes());

        return LoginResponseDto.builder().type("Basic").token(token).build();
    }

}