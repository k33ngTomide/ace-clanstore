package com.acaclan.aceclan.dto.request;


import lombok.Data;

@Data
public class RegisterClanRequest {

    private String username;
    private String password;
    private String email;
}
