package com.acaclan.aceclan.dto.request;

import lombok.Data;

@Data
public class AddPictureRequest<T> {

    private T picture;
    private String username;

}