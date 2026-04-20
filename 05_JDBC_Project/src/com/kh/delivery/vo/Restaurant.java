package com.kh.delivery.vo;

public record Restaurant(int restNo,
						 String restName,
						 String category,
						 int minPrice,
						 int deliveryFee) {
	
	
	


}


/*
 * 

-- 가게
CREATE TABLE RESTAURANT (
REST_NO       NUMBER        PRIMARY KEY,
REST_NAME     VARCHAR2(50)  NOT NULL,
CATEGORY      VARCHAR2(20)  NOT NULL CHECK (CATEGORY IN ('한식','중식','일식','양식','분식','치킨','피자')),
MIN_PRICE     NUMBER        DEFAULT 0,   -- 최소 주문 금액
DELIVERY_FEE  NUMBER        DEFAULT 3000
);
CREATE SEQUENCE SEQ_REST_NO START WITH 1 INCREMENT BY 1;




 */
