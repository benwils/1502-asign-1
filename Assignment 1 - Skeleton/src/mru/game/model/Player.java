package mru.game.model;

public class Player {
	
	/**
	 * This class represent each player record in the Database
	 * It is basically a model class for each record in the txt file
	 * @author Ben
	 */
	
	String name;
	String bal;
	int numOfWins;
	
	
	public Player(String name, String bal, int numOfWins) {
		this.name = name;
		this.bal = bal;
		this.numOfWins = numOfWins;
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	
	public void setBal(String bal) {
		this.bal = bal;
	}
	
	
	public String getBal() {
		return bal;
		
	}
	
	public void setNumOfWins(int numOfWins) {
		this.numOfWins = numOfWins;
	}
	
	public int getNumberOfWins() {
		return numOfWins;
	}
	
	public String toString() {
		return "Name: " + name + " Balance: $" + bal + " Number of Wins: " + numOfWins;
	}
	
	public String format() {
		return name+";"+bal+";"+numOfWins;
	}
	
		
	
	
}
