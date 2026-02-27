package com.example.officenavi.domain.userseat;

import jakarta.validation.constraints.NotNull;

/**
 * 社員の現在位置登録APIリクエストです。
 */
public class UserSeatRegisterRequest {

    @NotNull(message = "userIdは必須です")
    private Integer userId;

    @NotNull(message = "seatIdは必須です")
    private Integer seatId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }
}
