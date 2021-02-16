CREATE TABLE `USER` 
(
 	 `USER_NO`	 BIGINT   NOT NULL,
 	 `NICK_NM`	 VARCHAR(100)  ,
 	 `PWD`	 VARCHAR(100)  ,
 	 `EMAIL`	 VARCHAR(100)  ,
 	 `ROLE`	 VARCHAR(100)  ,
 	 `LOGIN_DT`	 DATETIME ,
 	 `REG_DT`	 DATETIME 
 )
    ENGINE = InnoDB
    CHARACTER SET = utf8
    ROW_FORMAT = DEFAULT;


ALTER TABLE `USER`
 ADD CONSTRAINT USER_PK PRIMARY KEY ( `USER_NO` );

CREATE TABLE `PROJECT` 
(
 	 `PROJECT_NO`	 BIGINT   NOT NULL,
 	 `PROJECT_TITLE`	 VARCHAR(255)    NOT NULL,
 	 `PROJECT_DESC`	 TEXT ,
 	 `OPEN_YN`	 TINYINT   NOT NULL,
 	 `REG_DT`	 DATETIME   NOT NULL,
 	 `UPDATE_DT`	 DATETIME   NOT NULL
 )
    ENGINE = InnoDB
    CHARACTER SET = utf8
    ROW_FORMAT = DEFAULT;


ALTER TABLE `PROJECT`
 ADD CONSTRAINT PROJECT_PK PRIMARY KEY ( `PROJECT_NO` );

CREATE TABLE `TASK` 
(
 	 `TASK_NO`	 BIGINT   NOT NULL,
 	 `PROJECT_NO`	 BIGINT   NOT NULL,
 	 `MANAGER_NO`	 BIGINT   NOT NULL,
 	 `TASK_TITLE`	 VARCHAR(255)    NOT NULL,
 	 `TASK_DESC`	 TEXT ,
 	 `START_DT`	 DATETIME ,
 	 `END_DT`	 DATETIME ,
 	 `STATE`	 TINYINT   NOT NULL,
 	 `REG_DT`	 DATETIME   NOT NULL,
 	 `UPDATE_DT`	 DATETIME   NOT NULL
 )
    ENGINE = InnoDB
    CHARACTER SET = utf8
    ROW_FORMAT = DEFAULT;


ALTER TABLE `TASK`
 ADD CONSTRAINT TASK_PK PRIMARY KEY ( `TASK_NO` );

ALTER TABLE `TASK`
 ADD CONSTRAINT `TASK_FK` FOREIGN KEY ( `MANAGER_NO` )
 REFERENCES `USER` ( `USER_NO` );

ALTER TABLE `TASK`
 ADD CONSTRAINT `TASK_FK1` FOREIGN KEY ( `PROJECT_NO` )
 REFERENCES `PROJECT` ( `PROJECT_NO` );

