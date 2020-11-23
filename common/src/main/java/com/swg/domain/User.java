package com.swg.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;
    @Column
    private String nickNm;
    @Column
    private String pwd;
    @Column
    private String email;
    @Column
    private Date loginDt;
    @Column
    private Date regDt;
}
