package com.example.microserv.entity;

public class JwtResponse {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JwtResponse(String pToken)
    {
        this.token=pToken;
    }
}
