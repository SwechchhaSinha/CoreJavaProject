package com.cafe.beans;

public class AddOn {
	private int addOnId, addOnPrice, addOnQuantity;
	private String addOnName, addOnCategory;
	
	public AddOn(){
		
	}
	public AddOn(int addOnId, int addOnPrice, int addOnQuantity, String addOnName, String addOnCategory) {
		super();
		this.addOnId = addOnId;
		this.addOnPrice = addOnPrice;
		this.addOnQuantity = addOnQuantity;
		this.addOnName = addOnName;
	}
	public int getAddOnId() {
		return addOnId;
	}
	public void setAddOnId(int addOnId) {
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
		return "AddOn [addOnId=" + addOnId + ", addOnPrice=" + addOnPrice + ", addOnQuantity=" + addOnQuantity
				+ ", addOnName=" + addOnName + ", addOnCategory=" + addOnCategory + "]";
	}
	
	
	
}
