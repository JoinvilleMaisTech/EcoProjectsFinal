package com.ecoprojectsfinal.dtos.usersDto;


import lombok.Data;

@Data
public class UserRequestDto {

    private String name;
    private String username;
    private String password;
    private String role;

}