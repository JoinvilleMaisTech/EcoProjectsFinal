package com.ecoprojectsfinal.services.loginServices;

import com.ecoprojectsfinal.dtos.loginDto.LoginRequestDto;
import com.ecoprojectsfinal.dtos.loginDto.LoginResponseDto;

public interface LoginService {
    LoginResponseDto authenticate(LoginRequestDto dto);

}
