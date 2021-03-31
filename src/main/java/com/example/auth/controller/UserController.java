package com.example.auth.controller;

import com.example.auth.MemberService;
import com.example.auth.TokenResponse;
import com.example.auth.dto.request.UserJoinRequestBody;
import com.example.auth.dto.request.UserSignInRequestBody;
import com.example.auth.dto.view.SignInResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final MemberService memberService;

    public UserController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping(value = "/join")
    public void join(@RequestBody UserJoinRequestBody request) {
        memberService.join(request);
    }

    @GetMapping(value = "/member")
    public String searchMember(@RequestParam String id) {
        return memberService.searchMember(id);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<SignInResponse> signIn(@RequestBody UserSignInRequestBody request) {
        return ResponseEntity.ok().body(memberService.signIn(request));
    }
}
