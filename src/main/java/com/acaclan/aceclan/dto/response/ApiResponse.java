package com.acaclan.aceclan.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T>{

    private T data;
    private String status;
    private String message;
}

