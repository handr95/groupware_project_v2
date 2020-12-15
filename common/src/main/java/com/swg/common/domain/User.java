package com.swg.common.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
@Entity
@Table(name = "USER")
public class User extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_NO")
    private Long userNo;
    @Column(name="NICK_NM", nullable = false)
    private String nickNm;
    @Column(name="PWD", nullable = false)
    private String pwd;
    @Column(name="EMAIL", nullable = false)
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(name="ROLE", nullable = false)
    private Role role;


    @Builder
    public User(String _nickNm, String _pwd, String _email, Role _role) {
        this.nickNm = _nickNm;
        this.pwd = _pwd;
        this.email = _email;
        this.role = _role;
    }
}
