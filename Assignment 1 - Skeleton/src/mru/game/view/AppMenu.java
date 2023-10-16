package mru.game.view;

import java.util.Scanner;

import mru.game.model.Player;

public class AppMenu {

    /**
     * This class will be used to show the menus and sub menus to the user
     * It also prompts the user for the inputs and validates them 
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
	    System.out.println("Enter a character here:");
	    char option = input.nextLine().toLowerCase().charAt(0);
	    return option;

	    
	}
    
    public String promptName() {
    	System.out.println("Enter a name here:");
    	String name = input.nextLine().trim().toLowerCase();
    	return name;
    }
    
    public void showPlayer(Player ply) {
    	if (ply !=null)
    		System.out.println(ply);
    	else
    		System.out.println("No record found for that name!");
    }

    public String promptId() {
        System.out.println("Enter a id here:");
        String id = input.nextLine().trim();
        return id;
    }
}


	

