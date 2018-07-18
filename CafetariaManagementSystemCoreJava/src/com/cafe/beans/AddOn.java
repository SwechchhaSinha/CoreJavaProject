package com.cafe.beans;

public class AddOn {
	private String addOnId, addOnName, addOnCategory;;
	private int addOnPrice, addOnQuantity;
	
	
	public AddOn(){
		
	}
	public AddOn(String addOnId, String addOnName,int addOnPrice, int addOnQuantity,  String addOnCategory) {
		super();
		this.addOnId = addOnId;
		this.addOnPrice = addOnPrice;
		this.addOnQuantity = addOnQuantity;
		this.addOnName = addOnName;
		this.addOnCategory=addOnCategory;
	}

	public String getAddOnId() {
		return addOnId;
	}
	public void setAddOnId(String addOnId) {
		this.addOnId = addOnId;
	}
	public int getAddOnPrice() {
		return addOnPrice;
	}
	public void setAddOnPrice(int addOnPrice) {
		this.addOnPrice = addOnPrice;
	}
	public int getAddOnQuantity() {
		return addOnQuantity;
	}
	public void setAddOnQuantity(int addOnQuantity) {
		this.addOnQuantity = addOnQuantity;
	}
	public String getAddOnName() {
		return addOnName;
	}
	public void setAddOnName(String addOnName) {
		this.addOnName = addOnName;
	}
	public String getAddOnCategory() {
		return addOnCategory;
	}
	public void setAddOnCategory(String addOnCategory) {
		this.addOnCategory = addOnCategory;
	}
	@Override
	public String toString() {
		return String.format("%-10s|", addOnId)+  String.format("%-25s|", addOnName)+String.format("%-15s|", addOnCategory)  + String.format("%-7d|", addOnQuantity)
				+ String.format("%s%-10d|","Rs. ",addOnPrice)  ;
	}
	
	
	
}
