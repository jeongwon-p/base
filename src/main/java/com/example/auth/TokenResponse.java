package com.example.auth;

public class TokenResponse {
    private String acesssToken;
    private String tokenType;

    public TokenResponse(String acesssToken, String tokenType) {
        this.acesssToken = acesssToken;
        this.tokenType = tokenType;
    }

    public String getAcesssToken() {
        return acesssToken;
    }

    public String getTokenType() {
        return tokenType;
    }
}
