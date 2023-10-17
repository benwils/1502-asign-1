package mru.testasign1;

import static org.junit.Assert.*;
import org.junit.*;

import mru.game.controller.PuntoBancoGame;

	public class PuntoBancoGameTest {
		@Test
		public void testStartNewGame() {
			PuntoBancoGame game = new PuntoBancoGame();
			char betOn = 'p'; // Assuming the player bets on Player
        
        
        
			String result = game.startNewGame(betOn);
				assertNotNull(result); // Ensure that the result is not null
					assertTrue(result.equals("win") || result.equals("loss") || result.equals("tieWin")); // Check if result is one of the expected values
    }

		@Test
		public void testGetResults() {
			PuntoBancoGame game = new PuntoBancoGame();
    
			// Test cases for getResults
			String result1 = game.getResults('p'); // Assuming player bets on Player
			String result2 = game.getResults('b'); // Assuming player bets on Banker
    		String result3 = game.getResults('t'); // Assuming player bets on Tie
    
    			assertNotNull(result1);
    			assertNotNull(result2);
    			assertNotNull(result3);
    
    			assertTrue(result1.equals("win") || result1.equals("loss") || result1.equals("tieWin"));
    			assertTrue(result2.equals("win") || result2.equals("loss") || result2.equals("tieWin"));
    			assertTrue(result3.equals("win") || result3.equals("loss") || result3.equals("tieWin"));
}	
	}