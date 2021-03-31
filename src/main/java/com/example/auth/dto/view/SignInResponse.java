package com.example.auth.dto.view;

public class SignInResponse {

    private String name;

    private String token;

    private String userId;

    public SignInResponse(String name, String token, String userId) {
        this.name = name;
        this.token = token;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }

    public String getUserId() {
        return userId;
    }
}
