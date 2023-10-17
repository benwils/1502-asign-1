package mru.game.view;

import java.util.List;
import java.util.Scanner;

import mru.game.controller.Card;
import mru.game.model.Player;

/**
 * 
 * shows the menus and sub menus
 * @author benwils and aiden20217
 * @version final
 */

public class GameMenu {
	
	Scanner input;
	
	/**
	 * default constructor
	 */
	public GameMenu() {
		input = new Scanner(System.in);
	}
	/**
	 * welcomes player back to game if they are a returning player
	 * @param p
	 */
	public void showExistingMenu(Player p) {
		System.out.println("\n" + "*".repeat(76));
		System.out.printf("***   Welcome back %-10s---    Your balance is: %-2s $                ***\n", p.getName(), p.getBalance());
		System.out.println("*".repeat(76));
	}
	/**
	 * welcomes new players to the game
	 * @param p
	 */
	public void showNewMenu(Player p) {
		System.out.println("\n" + "*".repeat(76));
		System.out.printf("***   Welcome %-15s---    Your balance is: %-2s $                ***\n", p.getName(), p.getBalance());
		System.out.println("*".repeat(76));
	}
	/**
	 * lets players input who they would like to bet on
	 * @return
	 */
	public char showBetMenu() {
	    System.out.println("Who do you want to bet on?\n");
	    System.out.println("\t(P) Player Wins");
	    System.out.println("\t(B) Banker Wins");
	    System.out.println("\t(T) Tie Game\n");
	    System.out.print("Enter your Choice: ");
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
	/**
	 * lets players input how much they would like to bet
	 * @param p
	 * @return
	 */
	public int showBetAmountMenu(Player p) {
		int option;

		while (true) {
			System.out.print("\nHow much do you want to bet this round? ");
	        int userInput = input.nextInt();
	        
	        input.nextLine();

	        if (userInput <= p.getBalance()) {
	            option = userInput;
	            break;
	        }

	        System.out.println("You don't have that much in your balance! ");
	    }

	    return option;
	}
	/**
	 * shows if the user lost, won or tied the game
	 * @param betAmount
	 * @param result
	 * @param playerCards
	 * @param bankerCards
	 * @param playerScore
	 * @param bankerScore
	 */
	public void showGameEndMenu(int betAmount, String result, List<Card> playerCards, List<Card> bankerCards, int playerScore, int bankerScore) {
		
		System.out.println("\n\t\t - PUNTO BANCO - ");
		System.out.println("+=======================+=======================+");
		System.out.println("||PLAYER                |Banker                ||");
		System.out.println("+=======================+=======================+");
		System.out.printf("| %-22s| %-22s|\n", playerCards.get(0), bankerCards.get(0));
		System.out.println("+-----------------------+-----------------------+");
		System.out.printf("| %-22s| %-22s|\n", playerCards.get(1), bankerCards.get(1));
		System.out.println("+-----------------------+-----------------------+");
		
		if(playerCards.size() == 3 && bankerCards.size() == 3) {
			System.out.printf("| %-22s| %-22s|\n", playerCards.get(2), bankerCards.get(2));
		}
		else if (playerCards.size() == 3) {
			System.out.println("| " + playerCards.get(2).toString() + " |                       |");
			System.out.printf("| %-22s| %-22s|\n", playerCards.get(2), " ");
		}
		else if (bankerCards.size() == 3) {
			System.out.println("|                       | " + bankerCards.get(2) + "|");
			System.out.printf("| %-22s| %-22s|\n", " ", bankerCards.get(2));
		}
		else {
			System.out.println("|                       |                       |");
		}
		
		System.out.println("+-----------------------+-----------------------+");
		System.out.println("|PLAYER POINTS: " + playerScore + "       |BANKER POINTS: " + bankerScore + "       +");
		System.out.println("+=======================+=======================+");	
		
		if (result.equals("loss")) {
			System.out.println("\n\t$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.printf("\t$       PLAYER LOST $%-10d$\n", betAmount);
			System.out.println("\t$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		}
		else if (result.equals("win")) {
			System.out.println("\n\t$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.printf("\t$       PLAYER WON $%-11d$\n", betAmount);
			System.out.println("\t$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		}
		else if (result.equals("tieWin")){
			System.out.println("\n\t$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.printf("\t$       PLAYER WON $%-11d$\n", (betAmount*5));
			System.out.println("\t$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		}
	}
}