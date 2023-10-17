package mru.game.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mru.game.model.Player;
import mru.game.view.AppMenu;
import mru.game.view.GameMenu;

/**
 * 
 * This class laods and the txt file into an array list and is 
 * able to save and store the array list to the txt file.
 * 
 *@author benwils and Aiden20217
 *@version final
 */

public class GameManager {

	private final String FILE_PATH = "res/CasinoInfo.txt";
	public ArrayList<Player> players; 
	public AppMenu appMen;
	PuntoBancoGame pbg;
	GameMenu gameMenu;
	
	/**
	 * defualt constructor initializes the players arraylist, appMen, gameMenu, and pbg.
	 * loads the data for the players and launches the application
	 * @throws Exception
	 */
	public GameManager() throws Exception {
		players = new ArrayList<>();
		appMen = new AppMenu();
		gameMenu = new GameMenu();
		pbg = new PuntoBancoGame();
		
		
		loadData();
		launchApplication();
	}
	/**
	 * lets player input a new to play the game, search, or save their game
	 * @throws IOException
	 */
private void launchApplication() throws IOException {
		
		boolean flag = true;
		int option;
		
		while(flag) {
			option = appMen.showMainMenu();
			
			switch (option) {
			case 1:
				playGame();
				break;
			case 2:
				Search();
				break;
			case 3:
				Save();
				flag = false;
				break;
			}}
			
		}

	/**
	 * checks if the player is new or returning then gives them $100 if they are new or tells them their balance is too low
	 * to play else it starts the game
	 * @throws IOException
	 */
	public void playGame() throws IOException {
		String name = appMen.promptName();
		name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
		Player p = searchByName(name);
		
		if (p == null) {
			players.add(new Player (name, 100, 0));
			p = searchByName(name);
			gameMenu.showNewMenu(p);
		}
		else {
			gameMenu.showExistingMenu(p);
		}
		
		if (p.getBalance() == 0){
			System.out.println("Your balance is too low to play! ");
			launchApplication();
		}
		else {
			startGame(p);
		}
	}
	/**
	 * starts the game, sets the balance if they have won or tied and lets the player play again
	 * @param p
	 */
	private void startGame(Player p) {
		char betOn = BetOn();
		int betAmount = BetAmount(p);
		
		String result = pbg.startNewGame(betOn);
		
		gameMenu.showGameEndMenu(betAmount, result, pbg.getPlayerCards(), pbg.getBankerCards(), pbg.getPlayerScore(), pbg.getBankerScore() );
		
		if (result.equals("Win")) {
			p.setBalance(betAmount);
		}
		else if (result.equals("tieWin")) {
			p.setBalance(betAmount*5);
		}
		else {
			p.setBalance(-betAmount);
		}
		char playAgain = appMen.promptNewGame();
		if (playAgain == 'y') {
			startGame(p);
		}
	}
	/**
	 * opens the menu for the player to choose who they bet on
	 * @return
	 */
	private char BetOn() {
		char option = gameMenu.showBetMenu();

		return option;
	}
	/**
	 * opens the menu for the player to input their bet amount
	 * @param p
	 * @return
	 */
	private int BetAmount(Player p) {
		int option = gameMenu.showBetAmountMenu(p);
		
		return option;
	}
	
	

	/**
	 * sub menu for if the player wants to find the top player, search for a certain player or go back to main menu
	 */
	private void Search() {
		char option = appMen.showSubMenu();
		
		switch(option) {
		case 't':
			FindTopPlayers();
			break;
		case 's':
			String name = appMen.promptName();
			Player ply = searchByName(name);
			System.out.println("                         - PLAYER INFO -                      "
	                + "\n+===================+========================+=======================+"
	                + "\n|NAME               |# WINS                  |BALANCE                |"
	                + "\n+===================+========================+=======================+"
	                + "\n|" + String.format("%-19s", ply.getName()) + "|" + String.format("%-24s", ply.getNumberOfWins()) + "|$" + String.format("%-22s", ply.getBalance()) + "|"
	                + "\n+-------------------+------------------------+-----------------------+"
	            );
			break;
		case 'b':
			break;
		}
	}
	/**
	 * takes in a input to search for a player
	 * @param name
	 * @return
	 */
	public Player searchByName(String name) {
	    Player ply = null;

	    for(Player p: players) {
	        if (p.getName().equalsIgnoreCase(name)) {
	            ply = p;
	            break;
	        }
	    }

	    if (ply != null) {
	        String capitalizedFirstName = ply.getName().substring(0, 1).toUpperCase() + ply.getName().substring(1).toLowerCase();
	        ply.setName(capitalizedFirstName);
	    }

	    return ply;
	}
		
	
	
		
	/**
	 * finds the players with the top scores
	 */
	public void FindTopPlayers() {
	    List<Player> topPlayers = new ArrayList<>();
	    topPlayers.add(players.get(0));

	    for (int i = 1; i < players.size(); i++) {
	        Player currentPlayer = players.get(i);
	        if (currentPlayer.getNumberOfWins() > topPlayers.get(0).getNumberOfWins()) {
	            topPlayers.clear();
	            topPlayers.add(currentPlayer);
	        } else if (currentPlayer.getNumberOfWins() == topPlayers.get(0).getNumberOfWins()) {
	            topPlayers.add(currentPlayer);
	        }
	    }

	    System.out.println("             - TOP PLAYERS -                      "
	            + "\n+===================+========================+"
	            + "\n|NAME               |# WINS                  |"
	            + "\n+===================+========================+");
	    
	    for (Player player : topPlayers) {
	        System.out.println("|" + String.format("%-19s", player.getName()) + "|" + String.format("%-24s", player.getNumberOfWins()) + "|"
	                + "\n+-------------------+------------------------+");
	    }
	}
	/**
	 * saves the players data to the txt file
	 * @throws IOException
	 */
	private void Save() throws IOException {
		File db = new File(FILE_PATH);
		PrintWriter pw = new PrintWriter(db);
		
		
		for (Player p: players) {
			pw.println(p.format());
		}
		
		pw.close();
		
	}
	/**
	 * loads the players data from the txt file
	 * @throws Exception
	 */
	private void loadData() throws Exception {
		File db = new File(FILE_PATH);
		String currentLine;
		String[] splittedLine;
		
		
		/**
		 * takes the text from the txt file into an arraylist
		 */
		if(db.exists()) {
			Scanner fileReader = new Scanner(db);
			
			while (fileReader.hasNextLine()) {
				
				currentLine = fileReader.nextLine();
				splittedLine = currentLine.split(";");
				Player p = new Player(splittedLine[0], Integer.parseInt(splittedLine[1]), Integer.parseInt(splittedLine[2]));
				players.add(p);
				
			}
			fileReader.close();
			
		}
	}
	

}
