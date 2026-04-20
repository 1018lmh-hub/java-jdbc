package com.kh.delivery.dto;

public class MenuDto {
	private int menuNo;
	private int restNo;
	private String menuName;
	private int price;
	private char soldOut;
	
	
	
	public MenuDto() {
		super();
	}

	public MenuDto(String menuName, int price, char soldOut) {
		super();
		this.menuName = menuName;
		this.price = price;
		this.soldOut = soldOut;
	}

	public MenuDto(int menuNo, int restNo, String menuName, int price, char soldOut) {
		super();
		this.menuNo = menuNo;
		this.restNo = restNo;
		this.menuName = menuName;
		this.price = price;
		this.soldOut = soldOut;
	}

	
	
	public int getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}

	public int getRestNo() {
		return restNo;
	}

	public void setRestNo(int restNo) {
		this.restNo = restNo;
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

	public char getSoldOut() {
		return soldOut;
	}

	public void setSoldOut(char soldOut) {
		this.soldOut = soldOut;
	}

	@Override
	public String toString() {
		return "MenuDto [menuNo=" + menuNo + ", restNo=" + restNo + ", menuName=" + menuName + ", price=" + price
				+ ", soldOut=" + soldOut + "]";
	}

	
	
	
}
