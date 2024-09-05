package com.sy.board.User;

import jakarta.validation.constraints.NotEmpty;

public class UserLoginForm {

    @NotEmpty(message = "아이디를 입력해주세요")
    private String username;

    @NotEmpty(message = "비밀번호를 입력해주세요")
    private String password;
}
