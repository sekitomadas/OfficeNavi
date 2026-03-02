package com.example.officenavi.domain.userseat;

import jakarta.validation.constraints.NotNull;

/**
 * 社員の退席APIリクエストです。
 */
public class UserSeatLeaveRequest {

    @NotNull(message = "userIdは必須です")
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}