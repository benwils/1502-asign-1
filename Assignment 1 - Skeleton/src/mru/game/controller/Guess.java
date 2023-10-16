package mru.game.controller;

import java.util.Random;

import mru.game.view.GameMenu;

public class Guess {
	
	
	Random rnd; 
	GameMenu gm;
	
	public Guess() {
		rnd = new Random();
		gm = new GameMenu();

		
	}

	public boolean lunchGame() {
		int guess;
		int compNumber = rnd.nextInt(10) + 1;
		boolean win = false;
		
		
		for (int i = 1; i<=3; i++) {
			guess = gm.showGameMenu();
			
			if (compNumber > guess) {
				gm.showGreaterMsg();
			} else if (compNumber < guess ) {
				gm.showLessMsg();
			} else {
				gm.showCong();
				win = true;
				break;
			}
		}
		
		if (!win) {
			gm.showSorryMsg(compNumber);
		}
		
		return win;
		
	}
	
	
	
	
	

}
