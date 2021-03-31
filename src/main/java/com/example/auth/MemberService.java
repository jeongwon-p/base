package com.example.auth;

import com.example.auth.dao.MemberRepository;
import com.example.auth.dto.request.UserJoinRequestBody;
import com.example.auth.dto.request.UserSignInRequestBody;
import com.example.auth.dto.view.SignInResponse;
import com.example.auth.entity.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public MemberService(MemberRepository memberRepository, JwtTokenProvider jwtTokenProvider) {
        this.memberRepository = memberRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Transactional
    public void join(UserJoinRequestBody request) {
        memberRepository.save(request.toEntity());
    }

    public String searchMember(String id) {
        return memberRepository.findById(id)
                .orElseThrow(RuntimeException::new)
                .getName();
    }

    @Transactional
    public SignInResponse signIn(UserSignInRequestBody request) {
        Member member = memberRepository.findById(request.getUserId())
                .orElseThrow(IllegalAccessError::new);

        return new SignInResponse(
                member.getName(),
                this.createToken(member.getId()),
                member.getId()
        );
    }

    public String createToken(String userId) {
        return jwtTokenProvider.createToken(userId);
    }
}
