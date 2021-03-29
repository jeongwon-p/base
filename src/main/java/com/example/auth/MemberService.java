package com.example.auth;

import com.example.auth.dao.MemberRepository;
import com.example.auth.dto.request.UserJoinRequestBody;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
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
}
