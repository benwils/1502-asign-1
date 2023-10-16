package mru.game.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import mru.game.model.Player;
import mru.game.view.AppMenu;


public class GameManager {
	
	/**
	 * 
	 * this class laods and the txt file into an array list and is able to save and store the array list to the txt file 
	 *@author ben
	 */
	private final String FILE_PATH = "res/CasinoInfo.txt";
	ArrayList<Player> players; 
	AppMenu appMen;
	PuntoBancoGame pbg;
	Guess gs;
	
	public GameManager() throws Exception {
		players = new ArrayList<>();
		appMen = new AppMenu();
		
		
		loadData();
		launchApplication();
	}
	// main menu
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

	private void playGame() {
		String name = appMen.promptName().toUpperCase();
		Player p = searchByName(name);
		int intWin = 0;
		if (p == null) {
			
			String bal = appMen.promptBal();
			players.add(new Player (name, bal, intWin));
			
		}
		
		gs = new Guess();
		boolean win = gs.lunchGame();
		if (win) {
			for (Player pl: players) {
				if (pl.getName().equals(name)) {
					int num = pl.getNumberOfWins();
					pl.setNumOfWins(num+1);
				}
			}
		}
		
	
	}
	// sub menu
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
		
		
		for(Player p: players) {
			if (p.getName().equals(name)) {
				ply = p;
				break;
		}
		}
		return ply;
	}
		
	// finds and displays the players with the top score
	private void FindTopPlayer() {
		Player topPlayer = players.get(0);
		
		for (int i = 1; i<players.size(); i++) {
			Player currentPlayer = players.get(i);
			if (currentPlayer.getNumberOfWins() > topPlayer.getNumberOfWins()) {
				topPlayer = currentPlayer;
			}
		}
		System.out.println("			 - TOP PLAYERS -					  "
				           + "\n+===================+========================+"
				           + "\n|NAME               |# WINS                  |"
				           + "\n+===================+========================+"
				           + "\n|Khosro             |18                      |"
				           + "\n+-------------------+------------------------+"
				           + "\n|Eli                |18                      |"
				           + "\n+-------------------+------------------------+"
				           );
		
	}
	// saves player data
	private void Save() throws IOException {
		File db = new File(FILE_PATH);
		PrintWriter pw = new PrintWriter(db);
		
		
		for (Player p: players) {
			pw.println(p.format());
		}
		
		pw.close();
		
	}
	//loads data
	private void loadData() throws Exception {
		File db = new File(FILE_PATH);
		String currentLine;
		String[] splittedLine;
		
		
		// takes the text from the file and puts it into the arraylist
		if(db.exists()) {
			Scanner fileReader = new Scanner(db);
			
			while (fileReader.hasNextLine()) {
				
				currentLine = fileReader.nextLine();
				splittedLine = currentLine.split(";");
				Player p = new Player(splittedLine[0], splittedLine[1], Integer.parseInt(splittedLine[2]));
				players.add(p);
				
			}
			fileReader.close();
			
		}
	}
	

}
