package com.example.officenavi.controller;

import com.example.officenavi.domain.user.UserResponse;
import com.example.officenavi.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 従業員関連APIを提供するコントローラーです。
 */
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    /**
     * コンストラクタインジェクションでサービスを受け取ります。
     *
     * @param userService 従業員サービス
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 従業員一覧を取得します。
     *
     * @return 従業員一覧レスポンス
     */
    @GetMapping("/users")
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }
    
}
