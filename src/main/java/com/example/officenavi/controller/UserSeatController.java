package com.example.officenavi.controller;

import com.example.officenavi.domain.userseat.UserSeatRegisterRequest;
import com.example.officenavi.domain.userseat.UserSeatRegisterResponse;
import com.example.officenavi.service.UserSeatService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 在席情報関連APIを提供するコントローラーです。
 */
@RestController
@RequestMapping("/api")
public class UserSeatController {

    private final UserSeatService userSeatService;

    /**
     * コンストラクタインジェクションでサービスを受け取ります。
     *
     * @param userSeatService 在席情報サービス
     */
    public UserSeatController(UserSeatService userSeatService) {
        this.userSeatService = userSeatService;
    }

    /**
     * 社員の現在位置を登録します。
     *
     * @param request 在席情報登録リクエスト
     * @return 201 Created（登録した在席情報）
     */
    @PostMapping("/user-seats")
    public ResponseEntity<UserSeatRegisterResponse> registerCurrentSeat(
            @Valid @RequestBody UserSeatRegisterRequest request) {
        UserSeatRegisterResponse response = userSeatService.registerCurrentSeat(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
