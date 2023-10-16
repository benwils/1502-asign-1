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
	    System.out.print("Enter a number here:");
	    int option;
	    
	    while (true) {
	        if (input.hasNextInt()) {
	            option = input.nextInt();
	            if (option >= 1 && option <= 3) {
	                break;
	            }
	        }
	        input.nextLine(); // clear invalid input
	        System.out.println("Invalid input. Please enter a number between 1 and 3.");
	    }
	    
	    return option;
	}
    
	public char showSubMenu() {
	    System.out.println("select an option:\n");
	    System.out.println("\t(T) Top Player");
	    System.out.println("\t(S) Search by Name");
	    System.out.println("\t(B) Back to Main menu\n");
	    System.out.print("Enter a character here:");
	    char option;

	    while (true) {
	        String userInput = input.nextLine();

	        if (userInput.length() == 1 && Character.isLetter(userInput.charAt(0))) {
	            option = Character.toLowerCase(userInput.charAt(0));
	            break;
	        }

	        System.out.println("Invalid input. Please enter a valid character.");
	    }

	    return option;
	}
    
    public String promptName() {
    	System.out.print("\nEnter a name here:");
    	String name = input.next().trim().toLowerCase();
    	input.nextLine();
    	return name;
    }
    
    public void showPlayer(Player ply) {
    	if (ply !=null)
    		System.out.println(ply);
    	else
    		System.out.println("No record found for that name!");
    }

    public String promptId() {
        String id;
        boolean result;

        do {
            System.out.println("Enter an ID here:");
            id = input.nextLine().trim();
            result = areAllDigits(id);

            if (!result) {
                System.out.println("Please only enter digits.");
            }

        } while (!result);

        return id;
    }


    public static boolean areAllDigits(String s) {
        return s.matches("\\d+");
    }
    
    public char promptNewGame() {
    	System.out.print("\nDo you want to play again(Y/N)?");
    	String userInput = input.nextLine();

        char option = Character.toLowerCase(userInput.charAt(0));
    	
    	return option;
    }
}



	

