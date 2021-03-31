package com.example.auth.controller;

import com.example.auth.UserService;
import com.example.auth.dto.request.UserJoinRequestBody;
import com.example.auth.dto.request.SignInRequestBody;
import com.example.auth.dto.view.SignInResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/join")
    public void join(@RequestBody UserJoinRequestBody request) {
        userService.join(request);
    }

    @GetMapping(value = "/member")
    public String searchMember(@RequestParam String id) {
        return userService.searchMember(id);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<SignInResponse> signIn(@RequestBody SignInRequestBody request) {
        return ResponseEntity.ok().body(userService.signIn(request));
    }
}
