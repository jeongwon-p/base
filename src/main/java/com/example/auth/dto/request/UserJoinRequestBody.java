package com.example.auth.dto.request;

import com.example.auth.entity.User;

public class UserJoinRequestBody {

    private String id;

    private String name;

    public User toEntity(){
        return new User(id, name);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
