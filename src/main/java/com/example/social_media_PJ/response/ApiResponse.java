package com.example.social_media_PJ.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponse {
    private String message;
    private boolean status;

    public ApiResponse(String message, boolean b) {
    }
}
