package com.swg.common.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
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
    @Column(name="NICK_NM")
    private String nickNm;
    @Column(name="PWD")
    private String pwd;
    @Column(name="EMAIL")
    private String email;

    @Builder
    public User(String _nickNm, String _pwd, String _email) {
        this.nickNm = _nickNm;
        this.pwd = _pwd;
        this.email = _email;
    }
}
