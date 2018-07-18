package com.cafe.beans;

import java.time.LocalDate;

public class Transaction 
{
	private String food_id;
	LocalDate date;
	private int quantity,price;
	@Override
	public String toString() {
		return "Date=" + date + ", Food id=" + food_id + ", Quantity=" + quantity + ", Price="
				+ price;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
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
	public Transaction(LocalDate date, String trasaction_id, int quantity, int price) {
		super();
		this.date = date;
		this.food_id = trasaction_id;
		this.quantity = quantity;
		this.price = price;
	}

}
