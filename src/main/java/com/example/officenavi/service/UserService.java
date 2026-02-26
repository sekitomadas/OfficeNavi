package com.example.officenavi.service;

import com.example.officenavi.domain.user.UserEntity;
import com.example.officenavi.domain.user.UserResponse;
import com.example.officenavi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 従業員の業務ロジックを扱うサービスです。
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * コンストラクタインジェクションでリポジトリを受け取ります。
     *
     * @param userRepository 従業員リポジトリ
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 従業員一覧を取得し、レスポンス形式へ変換して返します。
     *
     * @return 従業員一覧レスポンス
     */
    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    /**
     * UserEntityをUserResponseに変換します。
     *
     * @param userEntity 従業員エンティティ
     * @return 従業員レスポンス
     */
    private UserResponse toResponse(UserEntity userEntity) {
        return new UserResponse(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail()
        );
    }
    
}
