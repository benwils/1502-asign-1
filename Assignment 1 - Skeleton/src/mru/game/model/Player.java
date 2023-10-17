package mru.game.model;


/**
 * 
 * This class represent each player record in the Database
 * It is basically a model class for each record in the txt file
 * @author benwils and aiden20217
 * @version final
 */

public class Player {
	
	String name;
	int balance;
	int numOfWins;
	
	/**
	 * default constructor and takes in the players name, balance, and number of wins
	 * @param name
	 * @param balance
	 * @param numOfWins
	 */
	public Player(String name, int balance, int numOfWins) {
		this.name = name;
		this.balance = balance;
		this.numOfWins = numOfWins;
		
	}
	/**
	 * sets the players name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * gets the players name
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * sets the players balance
	 * @param balance
	 */
	public void setBalance(int balance) {
		this.balance += balance;
	}
	
	/**
	 * gets the players balance
	 * @return
	 */
	public int getBalance() {
		return balance;
		
	}
	/**
	 * sets the number of wins for the player
	 * @param numOfWins
	 */
	public void setNumOfWins(int numOfWins) {
		this.numOfWins = numOfWins;
	}
	/**
	 * gets the number of wins for the player
	 * @return
	 */
	public int getNumberOfWins() {
		return numOfWins;
	}
	
	/**
	 * shows the players name with their balance and number of wins
	 */
	public String toString() {
		return "Name: " + name + " Balance: $" + balance + " Number of Wins: " + numOfWins;
	}
	
	/**
	 * formats the name, balance, and number of wins for the txt file
	 * @return
	 */
	public String format() {
		return name+";"+balance+";"+numOfWins;
	}
	
		
	
	
}
