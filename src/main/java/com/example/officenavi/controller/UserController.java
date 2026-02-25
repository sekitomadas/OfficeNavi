package com.example.officenavi.controller;

import com.example.officenavi.domain.user.UserResponse;
import com.example.officenavi.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * ユーザの一覧を取得するエンドポイント
     * @return
     */
    @GetMapping("/users")
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }
    
}
