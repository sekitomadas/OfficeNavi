package com.example.officenavi.service;

import com.example.officenavi.domain.user.UserEntity;
import com.example.officenavi.domain.user.UserResponse;
import com.example.officenavi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    /**
     * UserEntityをUserResponseに変換するユーティリティメソッド
     * @param userEntity
     * @return
     */
    private UserResponse toResponse(UserEntity userEntity) {
        return new UserResponse(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail()
        );
    }
    
}
