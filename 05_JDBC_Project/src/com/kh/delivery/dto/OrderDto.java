package com.kh.delivery.dto;

import java.sql.Date;

public class OrderDto {
	
	    // 기본 컬럼
	    private int orderNo;
	    private int memberNo;
	    private int menuNo;
	    private int quantity;
	    private Date orderDate;
	    private String status;

	    // JOIN 결과를 담을 추가 필드
	    private String memberName;   // MEMBER 조인
	    private String restName;     // RESTAURANT 조인
	    private String menuName;     // MENU 조인
	    private int price;           // MENU 조인
	    
	    
	    
		public OrderDto() {
		}
		
		
		
		
		public OrderDto(int orderNo, int memberNo, int menuNo, int quantity, Date orderDate, String status) {
			super();
			this.orderNo = orderNo;
			this.memberNo = memberNo;
			this.menuNo = menuNo;
			this.quantity = quantity;
			this.orderDate = orderDate;
			this.status = status;
		}




		public OrderDto(int orderNo, int memberNo, int menuNo, int quantity, Date orderDate, String status,
				String memberName, String restName, String menuName, int price) {
			this.orderNo = orderNo;
			this.memberNo = memberNo;
			this.menuNo = menuNo;
			this.quantity = quantity;
			this.orderDate = orderDate;
			this.status = status;
			this.memberName = memberName;
			this.restName = restName;
			this.menuName = menuName;
			this.price = price;
		}


		public int getOrderNo() {
			return orderNo;
		}
		public void setOrderNo(int orderNo) {
			this.orderNo = orderNo;
		}
		public int getMemberNo() {
			return memberNo;
		}
		public void setMemberNo(int memberNo) {
			this.memberNo = memberNo;
		}
		public int getMenuNo() {
			return menuNo;
		}
		public void setMenuNo(int menuNo) {
			this.menuNo = menuNo;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public Date getOrderDate() {
			return orderDate;
		}
		public void setOrderDate(Date orderDate) {
			this.orderDate = orderDate;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getMemberName() {
			return memberName;
		}
		public void setMemberName(String memberName) {
			this.memberName = memberName;
		}
		public String getRestName() {
			return restName;
		}
		public void setRestName(String restName) {
			this.restName = restName;
		}
		public String getMenuName() {
			return menuName;
		}
		public void setMenuName(String menuName) {
			this.menuName = menuName;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		
		@Override
		public String toString() {
			return "OrderDto [orderNo=" + orderNo + ", memberNo=" + memberNo + ", menuNo=" + menuNo + ", quantity="
					+ quantity + ", orderDate=" + orderDate + ", status=" + status + ", memberName=" + memberName
					+ ", restName=" + restName + ", menuName=" + menuName + ", price=" + price + "]";
		}

		
	    // getter / setter / toString
	    
	    
	    
	

}
