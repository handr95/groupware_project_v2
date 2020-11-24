package com.swg.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "USER")
public class User {

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
    @Column(name="LOGIN_DT")
    private Date loginDt;
    @Column(name="REG_DT")
    private Date regDt;
}
