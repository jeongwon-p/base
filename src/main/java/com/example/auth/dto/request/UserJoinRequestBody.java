package com.example.auth.dto.request;

import com.example.auth.entity.Member;

public class UserJoinRequestBody {

    private String id;

    private String name;

    public Member toEntity(){
        return new Member(id, name);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
