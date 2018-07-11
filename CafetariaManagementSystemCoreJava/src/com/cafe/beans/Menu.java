package com.cafe.beans;

import java.util.ArrayList;

public class Menu {
	ArrayList<String> menuArrayList = new ArrayList<>();
	private String menuCurrentDay;
	
	public Menu(){
		
	}
	
	public Menu(ArrayList<String> menuArrayList, String menuCurrentDay) {
		super();
		this.menuArrayList = menuArrayList;
		this.menuCurrentDay = menuCurrentDay;
	}


	public ArrayList<String> getMenuArrayList() {
		return menuArrayList;
	}
	public void setMenuArrayList(ArrayList<String> menuArrayList) {
		this.menuArrayList = menuArrayList;
	}
	public String getMenuCurrentDay() {
		return menuCurrentDay;
	}
	public void setMenuCurrentDay(String menuCurrentDay) {
		this.menuCurrentDay = menuCurrentDay;
	}

	@Override
	public String toString() {
		return "Menu [menuArrayList=" + menuArrayList + ", menuCurrentDay=" + menuCurrentDay + "]";
	}
	
	
	
	
}
