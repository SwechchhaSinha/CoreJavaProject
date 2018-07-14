package com.cafe.beans;

public class Food {
	private String f_id,f_name,category;
	private int quantity;
//	private int threshold;
//	public int getThreshold() {
//		return threshold;
//	}
//	public void setThreshold(int threshold) {
//		this.threshold = threshold;
//	}
	public String getF_id() {
		return f_id;
	}
	public void setF_id(String f_id) {
		this.f_id = f_id;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Food(String f_id, String f_name, String category, int quantity) {
		super();
		this.f_id = f_id;
		this.f_name = f_name;
		this.category = category;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Food [f_id=" + f_id + ", f_name=" + f_name + ", category=" + category + ", quantity=" + quantity + "]";
	}
	

}
