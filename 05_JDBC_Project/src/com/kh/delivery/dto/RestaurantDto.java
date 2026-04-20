package com.kh.delivery.dto;

public class RestaurantDto {
	private int restNo;
	private String restName;
	private String category;
	private int minPrice;
	private int deliveryFee;
	
	
	
	public RestaurantDto() {
	}

	public RestaurantDto(String restName, String category, int minPrice, int deliveryFee) {
		super();
		this.restName = restName;
		this.category = category;
		this.minPrice = minPrice;
		this.deliveryFee = deliveryFee;
	}

	public RestaurantDto(int restNo, String restName, String category, int minPrice, int deliveryFee) {
		this.restNo = restNo;
		this.restName = restName;
		this.category = category;
		this.minPrice = minPrice;
		this.deliveryFee = deliveryFee;
	}
	
	
	

	public int getRestNo() {
		return restNo;
	}

	public void setRestNo(int restNo) {
		this.restNo = restNo;
	}

	public String getRestName() {
		return restName;
	}

	public void setRestName(String restName) {
		this.restName = restName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public int getDeliveryFee() {
		return deliveryFee;
	}

	public void setDeliveryFee(int deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	@Override
	public String toString() {
		return "RestaurantDto [restNo=" + restNo + ", restName=" + restName + ", category=" + category + ", minPrice="
				+ minPrice + ", deliveryFee=" + deliveryFee + "]";
	}
	
	
	
	
	

}
