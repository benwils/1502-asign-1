package mru.game.model;

public class Player {
	
	/**
	 * This class represent each player record in the Database
	 * It is basically a model class for each record in the txt file
	 */
	
	String name;
	int balance;
	int numOfWins;
	
	
	public Player(String name, int balance, int numOfWins) {
		this.name = name;
		this.balance = balance;
		this.numOfWins = numOfWins;
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	
	public void setBalance(int balance) {
		this.balance += balance;
	}
	
	
	public int getBalance() {
		return balance;
	}
	
	public void setNumOfWins(int numOfWins) {
		this.numOfWins = numOfWins;
	}
	
	public int getNumberOfWins() {
		return numOfWins;
	}
	
	public String toString() {
		return "Name: " + name + " Balance: " + balance + " Number of Wins: " + numOfWins;
	}
	
	public String format() {
		return name+";"+balance+";"+numOfWins;
	}
	
		
	
	
}
