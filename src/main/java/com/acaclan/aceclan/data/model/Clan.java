package com.acaclan.aceclan.data.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("User")
public class Clan {

    private String id;
    private String username;

    @JsonIgnore
    private String password;
    private String email;
    private String dateCreated;

}
