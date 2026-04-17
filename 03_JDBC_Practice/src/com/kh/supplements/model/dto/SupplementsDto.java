package com.kh.supplements.model.dto;

public class SupplementsDto {
	private int supNo;
	private String supName;
	private int supPrice;
	private int pills;
	public SupplementsDto() {
		
	}
	
	
	
	public SupplementsDto(String supName, int supPrice, int pills) {
		super();
		this.supName = supName;
		this.supPrice = supPrice;
		this.pills = pills;
	}

	public SupplementsDto(int supNo, String supName, int supPrice, int pills) {
		super();
		this.supNo = supNo;
		this.supName = supName;
		this.supPrice = supPrice;
		this.pills = pills;
	}



	public int getSupNo() {
		return supNo;
	}

	public void setSupNo(int supNo) {
		this.supNo = supNo;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public int getSupPrice() {
		return supPrice;
	}

	public void setSupPrice(int supPrice) {
		this.supPrice = supPrice;
	}

	public int getPills() {
		return pills;
	}

	public void setPills(int pills) {
		this.pills = pills;
	}



	@Override
	public String toString() {
		return "SupplementsDto [supNo=" + supNo + ", supName=" + supName + ", supPrice=" + supPrice + ", pills=" + pills
				+ "]";
	}
	
	
	
	
	

}
