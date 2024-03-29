package com.acaclan.aceclan.data.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document("User")
public class Clan {

    private String id;

    @NotEmpty(message = "Username cannot be empty")
    private String username;

    @JsonIgnore
    private String password;

    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @NotEmpty(message = "phoneNumber cannot be empty")
    private String phoneNumber;

    @NotEmpty(message = "FunFact About you")
    private String funFact;

    private String pictureLink;

    private LocalDate dateCreated;

}
