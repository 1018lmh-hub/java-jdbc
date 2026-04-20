package com.kh.delivery.vo;

public record Menu(int menuNo,
				   int restNo,
				   String menuName,
				   int price,
				   char soldOut) {

}


/*
 * -- 메뉴 (가게별 메뉴)
CREATE TABLE MENU (
    MENU_NO       NUMBER        PRIMARY KEY,
    REST_NO       NUMBER        NOT NULL REFERENCES RESTAURANT(REST_NO),
    MENU_NAME     VARCHAR2(50)  NOT NULL,
    PRICE         NUMBER        NOT NULL,
    SOLD_OUT      CHAR(1)       DEFAULT 'N' CHECK (SOLD_OUT IN ('Y','N'))  -- Y면 품절
);
CREATE SEQUENCE SEQ_MENU_NO START WITH 1 INCREMENT BY 1;
 */
