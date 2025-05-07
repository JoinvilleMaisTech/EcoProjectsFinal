package com.ecoprojectsfinal.dtos.loginDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDto {

    private String type;
    private String token;

}