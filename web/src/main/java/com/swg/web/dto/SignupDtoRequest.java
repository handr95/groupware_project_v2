package com.swg.web.dto;

import com.swg.common.domain.Role;
import com.swg.common.domain.User;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignupDtoRequest {
    private String nickNm;
    private String pwd;
    private String email;
    private Role role;

    public User toEntity() {
        return User.builder()
            ._nickNm(nickNm)
            ._pwd(pwd)
            ._email(email)
            ._role(Role.GUEST)
            .build();
    }
}
