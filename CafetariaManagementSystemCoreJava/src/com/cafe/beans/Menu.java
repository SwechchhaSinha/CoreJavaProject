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
		return String.format("%-15s|",menuArrayList.get(0))+"\n"+
				String.format("%-15s|",menuArrayList.get(1))+"\n"+
				String.format("%-15s|",menuArrayList.get(2))+"\n"+
				String.format("%-15s|",menuArrayList.get(3))+"\n"+
				String.format("%-15s|",menuArrayList.get(4))+"\n"+
				String.format("%-15s|",menuArrayList.get(5))+"\n"+
				String.format("%-15s|",menuArrayList.get(6))+"\n"+
				String.format("%-15s|",menuArrayList.get(7)) ;
	}
	
	
	
	
}
