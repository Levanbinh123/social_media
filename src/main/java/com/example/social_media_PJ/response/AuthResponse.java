package com.example.social_media_PJ.response;

import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private String message;

    public AuthResponse(String token, String regiterSuccess) {
        this.token = token;
        this.message = regiterSuccess;
    }

    public AuthResponse() {

    }
}
