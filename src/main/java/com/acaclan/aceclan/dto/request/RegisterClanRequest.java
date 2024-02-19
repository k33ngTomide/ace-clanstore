package com.acaclan.aceclan.dto.request;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class RegisterClanRequest {

    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String funFact;
    private MultipartFile picture;

}
