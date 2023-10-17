package mru.game.view;

import java.util.Scanner;

/**
 * 
 * shows the menus and sub menus
 * @author benwils and aiden20217
 * @version final
 */


public class AppMenu {

	public Scanner input;
	
	/**
	 * default constructor
	 */
	public AppMenu() {
		input = new Scanner(System.in);
	}
    /**
     * lets players input if they want to play the game or search
     * @return
     */
	public int showMainMenu() {
	    System.out.println("select an option:\n");
	    System.out.println("\t1. Play Game");
	    System.out.println("\t2. Search");
	    System.out.println("\t3. Save and Exit\n");
	    System.out.println("Enter a number here:");
	    int option = input.nextInt();
	    return option;
	}
	    
	    
    /**
     * lets players input if they want to search for top player, a certain player to back to menu
     * @return
     */
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
    
	/**
	 * prompts the user to input their name 
	 * @return
	 */
	public String promptName() {
    	System.out.print("\nEnter a name here:");
    	String name = input.next().trim().toLowerCase();
    	input.nextLine();
    	return name;
    }
    
	/**
	 * prompts the user after the game if they want to play again or exit
	 * @return
	 */
	public char promptNewGame() {
		System.out.print("\nDo you want to play again(Y/N)?");
		String userInput = input.nextLine();

		char option = Character.toLowerCase(userInput.charAt(0));
	
		return option;
}
	}


	

