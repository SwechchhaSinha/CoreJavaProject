package mainclasspackage;

import com.cafe.ui.impl.InitialUserInterfaceImpl;

public class MainClass {

	public static void main(String[] args) {
		
		InitialUserInterfaceImpl initialUserInterfaceImpl=new InitialUserInterfaceImpl();
		while (true){
		initialUserInterfaceImpl.displayInitialMenu();
		}
	}

}
