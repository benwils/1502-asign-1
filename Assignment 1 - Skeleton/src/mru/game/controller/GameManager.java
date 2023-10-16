package mru.game.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import mru.game.model.Player;
import mru.game.view.AppMenu;
import mru.game.view.GameMenu;


public class GameManager {
	
	/* In this class toy'll need these methods:
	 * A constructor
	 * A method to load the txt file into an arraylist (if it exists, so you check if the txt file exists first)
	 * A save method to store the arraylist into the the txt file 
	 * A method to search for a player based their name
	 * A method to find the top players
	 * Depending on your designing technique you may need and you can add more methods here 
	 */
	private final String FILE_PATH = "res/CasinoInfo.txt";
	ArrayList<Player> players; 
	AppMenu appMen;
	PuntoBancoGame pbg;
	GameMenu gameMenu;
	
	public GameManager() throws Exception {
		players = new ArrayList<>();
		appMen = new AppMenu();
		gameMenu = new GameMenu();
		pbg = new PuntoBancoGame();
		
		
		loadData();
		launchApplication();
	}

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
			}
			
		}
		
	}

	private void playGame() throws IOException {
		String name = appMen.promptName();
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

	private char BetOn() {
		char option = gameMenu.showBetMenu();

		return option;
	}

	private int BetAmount(Player p) {
		int option = gameMenu.showBetAmountMenu(p);
		
		return option;
	}

	private void Search() {
		char option = appMen.showSubMenu();
		
		switch(option) {
		case 't':
			FindTopPlayer();
			break;
		case 's':
			String name = appMen.promptName();
			Player ply = searchByName(name);
			appMen.showPlayer(ply);
			break;
		case 'b':
			break;
		}
	}

	private Player searchByName(String name) {
		Player ply = null;
		
		
		for (Player p: players) {
			if(p.getName().equals(name)) {
				ply = p;
				break;
			}
		}
	
		return ply;
	}
	
	private void FindTopPlayer() {
		Player topPlayer = players.get(0);
		
		for (int i = 1; i<players.size(); i++) {
			Player currentPlayer = players.get(i);
			if (currentPlayer.getNumberOfWins() > topPlayer.getNumberOfWins()) {
				topPlayer = currentPlayer;
			}
		}
		System.out.println(topPlayer);
		
	}

	private void Save() throws IOException {
		File db = new File(FILE_PATH);
		PrintWriter pw = new PrintWriter(db);
		
		
		for (Player p: players) {
			pw.println(p.format());
		}
		
		pw.close();
		
	}

	private void loadData() throws Exception {
		File db = new File(FILE_PATH);
		String currentLine;
		String[] splittedLine;
		
		
		
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
