package com.kh.delivery.vo;

import java.sql.Date;

public record Order(	  
	    int orderNo,
	    int memberNo,
	    int menuNo,
	    int quantity,
	    Date orderDate,
	    String status,
	    String memberName, 
	    String restName, 
	    String menuName,   
	    int price)

	{}


/*
 * -- 주문 (1주문 = 1메뉴)
CREATE TABLE ORDERS (
    ORDER_NO      NUMBER        PRIMARY KEY,
    MEMBER_NO     NUMBER        NOT NULL REFERENCES DELI_MEMBER(MEMBER_NO),
    MENU_NO       NUMBER        NOT NULL REFERENCES MENU(MENU_NO),
    QUANTITY      NUMBER        DEFAULT 1,
    ORDER_DATE    DATE          DEFAULT SYSDATE,
    STATUS        VARCHAR2(20)  DEFAULT '주문접수'
                  CHECK (STATUS IN ('주문접수','조리중','배달중','배달완료','주문취소'))
);
 */
