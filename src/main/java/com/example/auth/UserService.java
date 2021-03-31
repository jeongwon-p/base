package com.example.auth;

import com.example.auth.dao.UserRepository;
import com.example.auth.dto.request.UserJoinRequestBody;
import com.example.auth.dto.request.SignInRequestBody;
import com.example.auth.dto.view.SignInResponse;
import com.example.auth.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public UserService(UserRepository userRepository, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Transactional
    public void join(UserJoinRequestBody request) {
        userRepository.save(request.toEntity());
    }

    public String searchMember(String id) {
        return userRepository.findById(id)
                .orElseThrow(RuntimeException::new)
                .getName();
    }

    @Transactional
    public SignInResponse signIn(SignInRequestBody request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(IllegalAccessError::new);

        return new SignInResponse(
                user.getName(),
                this.createToken(user.getId()),
                user.getId()
        );
    }

    public String createToken(String userId) {
        return jwtTokenProvider.createToken(userId);
    }
}
