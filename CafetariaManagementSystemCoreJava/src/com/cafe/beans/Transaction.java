package com.cafe.beans;

public class Transaction 
{
	private String date , food_id;
	private int quantity,price;
	@Override
	public String toString() {
		return "transaction [date=" + date + ", food_id=" + food_id + ", quantity=" + quantity + ", price="
				+ price + "]";
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFood_id() {
		return food_id;
	}
	public void setTrasaction_id(String trasaction_id) {
		this.food_id = trasaction_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Transaction(String date, String trasaction_id, int quantity, int price) {
		super();
		this.date = date;
		this.food_id = trasaction_id;
		this.quantity = quantity;
		this.price = price;
	}

}
