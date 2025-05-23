package com.ecoprojectsfinal.dtos.usersDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDto {

    private Long id;
    private String name;
    private String username;
    private String role;

}