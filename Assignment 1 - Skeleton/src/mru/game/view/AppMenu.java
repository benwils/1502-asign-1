package mru.game.view;

import java.util.Scanner;

import mru.game.model.Player;

public class AppMenu {

    /**
     * shows the menus and sub menus
     * @author Ben
     */
	Scanner input;
	
	public AppMenu() {
		input = new Scanner(System.in);
	}
    
	public int showMainMenu() {
	    System.out.println("select an option:\n");
	    System.out.println("\t1. Play Game");
	    System.out.println("\t2. Search");
	    System.out.println("\t3. Save and Exit\n");
	    System.out.println("Enter a number here:");
	    int option = input.nextInt();
	    return option;
	}
	    
	    
    
	public char showSubMenu() {
	    System.out.println("select an option:\n");
	    System.out.println("\t(T) Top Player");
	    System.out.println("\t(S) Search by Name");
	    System.out.println("\t(B) Back to Main menu\n");
	    String inputLine = input.nextLine().toLowerCase();
	    while (inputLine.isEmpty()) {
	        System.out.println("Please enter a character:");
	        inputLine = input.nextLine().toLowerCase();
	    }
	    
	    char option = inputLine.charAt(0);
	    return option;
	}
    
    public String promptName() {
    	System.out.println("Enter a name here:");
    	String name = input.nextLine().trim();
    	name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    	return name;
    }
    
    public void showPlayer(Player ply) {
    		System.out.println(ply);
    }    	
    public String promptBal() {
        System.out.println("Enter a bal here:");
        String bal = input.nextLine().trim();
        return bal;
    }
}


	

