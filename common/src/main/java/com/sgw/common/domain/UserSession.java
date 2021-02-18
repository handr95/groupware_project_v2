package com.sgw.common.domain;

import lombok.Getter;

@Getter
public class UserSession {
    private Long userNo;
    private String nickNm;
    private Role role;

    public UserSession(User user) {
        this.userNo = user.getUserNo();
        this.nickNm = user.getNickNm();
        this.role = user.getRole();
    }
}
