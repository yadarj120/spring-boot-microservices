package com.blueyonder.auth.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ApiErrorResponse {

    @NotNull(message = "Error code cannot be null")
    private int errorCode;

    @NotNull(message = "Error description cannot be null")
    private String description;
}
