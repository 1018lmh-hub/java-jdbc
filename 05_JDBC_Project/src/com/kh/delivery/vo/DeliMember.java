package com.kh.delivery.vo;

import java.sql.Date;

public record DeliMember(int memberNo, 
						 String memberId, 
						 String memberPw, 
						 String memberName, 
						 String address, 
						 Date enrollDate) {

}

/*
 * -- 회원
CREATE TABLE DELI_MEMBER (
    MEMBER_NO     NUMBER        PRIMARY KEY,
    MEMBER_ID     VARCHAR2(20)  NOT NULL UNIQUE,
    MEMBER_PW     VARCHAR2(20)  NOT NULL,
    MEMBER_NAME   VARCHAR2(30)  NOT NULL,
    ADDRESS       VARCHAR2(100) NOT NULL,
    ENROLL_DATE   DATE DEFAULT SYSDATE
);
CREATE SEQUENCE SEQ_MEMBER_NO START WITH 1 INCREMENT BY 1;
 */

