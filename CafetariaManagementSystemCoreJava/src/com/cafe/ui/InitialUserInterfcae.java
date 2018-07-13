package com.cafe.ui;

import com.cafe.beans.Menu;

public interface InitialUserInterfcae
{
	public void displayInitialMenu();
	public void performMyAction(int choice);
	void displayMenuForStock();
	int wantToOpt();
	void displayMenu(Menu menu, String str);
	void afterCorrectCredentials();
	void displayWrongCredentials();
}
