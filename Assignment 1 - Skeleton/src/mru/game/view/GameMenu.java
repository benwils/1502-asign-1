package mru.game.view;

import java.util.Scanner;

public class GameMenu {
	
	Scanner input;
	
	public GameMenu() {
		input = new Scanner(System.in);
	}

	public int showGameMenu() {
		int guess;
		
		System.out.println("Please enter a number between 1 and 10: ");
		guess = input.nextInt();
		
		return guess;
	}

	public void showGreaterMsg() {
		System.out.println("My number is greater than yours!");
		
	}

	public void showLessMsg() {
		System.out.println("My number is less than yours.");
		
	}

	public void showCong() {
		System.out.println("Congrats you've won!");
		
	}

	public void showSorryMsg(int number) {
		System.out.println("Sorry my number was " + number);
		
	}
	
	
	
}
