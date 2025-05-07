package com.ecoprojectsfinal.services.loginServices;

import com.ecoprojectsfinal.configs.JwtComponent;
import com.ecoprojectsfinal.dtos.loginDto.LoginRequestDto;
import com.ecoprojectsfinal.dtos.loginDto.LoginResponseDto;
import com.ecoprojectsfinal.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final JwtComponent jwtConfig;
    private final AuthenticationManager authenticationManager;

    @Override
    public LoginResponseDto authenticate(LoginRequestDto dto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getUsername(), dto.getPassword()
                )
        );

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new BadCredentialsException("Invalid username or password");
        }

        User user = (User) authentication.getPrincipal();
        String token = jwtConfig.generateToken(user);
        return LoginResponseDto.builder().type("Bearer").token(token).build();
    }
}
