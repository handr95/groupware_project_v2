package com.swg.web.dto;

import com.swg.common.domain.Role;
import com.swg.common.domain.User;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignupDtoRequest {
    private String nickNm;
    private String pwd;
    private String email;
    private Role role;

    public User toEntity(PasswordEncoder passwordEncoder) {
        return User.builder()
            ._nickNm(nickNm)
            ._pwd(passwordEncoder.encode(pwd))
            ._email(email)
            ._role(Role.GUEST)
            .build();
    }
}
