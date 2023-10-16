package mru.game.controller;

import java.util.ArrayList;
import java.util.List;



public class PuntoBancoGame {
	
	/**
	 * In this class you implement the game
	 * You should use CardDeck class here
	 * See the instructions for the game rules
	 */

	CardDeck myDeck = new CardDeck();
	private List<Card> playerCards = new ArrayList<Card>();
	private List<Card> bankerCards = new ArrayList<Card>();
	private int playerScore = 0;
	private int bankerScore = 0;
	private int cardsDrawn = 0;
	Card currentCard;
	
	
	public String startNewGame(char betOn) {
		//draw 2 card for each player
		while(cardsDrawn < 4) {
			if (cardsDrawn % 2 == 0) {
				bankerDraw();
			}
			else {
				playerDraw();
			}
		}
		if (playerScore == 8 || playerScore == 9 || bankerScore == 8 || bankerScore == 9 ) {
			//go to win or loss logic
		}
		if (playerScore < 6) {
			playerDraw();
		}
		if (cardsDrawn == 4 && bankerScore < 6) {
			bankerDraw();
		}
		if (cardsDrawn == 5 && currentCard.getRank() == 2 || currentCard.getRank() == 3 && bankerScore < 5) {
			bankerDraw();
		}
		if (cardsDrawn == 5 && currentCard.getRank() == 4 || currentCard.getRank() == 5 && bankerScore < 6) {
			bankerDraw();		
		}
		if (cardsDrawn == 5 && currentCard.getRank() == 6 || currentCard.getRank() == 7 && bankerScore < 7) {
			bankerDraw();
		}
		if (cardsDrawn == 5 && currentCard.getRank() == 8 && bankerScore < 3) {
			bankerDraw();
		}
		if (cardsDrawn == 5 && currentCard.getRank() == 1 || currentCard.getRank() < 9 && bankerScore < 4) {
			bankerDraw();
		}
		playerScore = playerScore % 10;
		bankerScore = bankerScore % 10;
		String result = getResults(betOn);
		return result;
	}
	
	private String getResults(char betOn) {
		if (playerScore > bankerScore && betOn == 'p') {
			return "win";
		}
		else if (playerScore == bankerScore && betOn == 't') {
			return "tieWin";
		}
		else if (playerScore < bankerScore && betOn == 'b'){
			return "win";
		}
		else {
			return "loss";
		}
	}
	
	private void bankerDraw() {
		currentCard = drawCard();
		bankerCards.add(currentCard);
		if (currentCard.getRank() < 10) {
			bankerScore += currentCard.getRank(); 
		}
		cardsDrawn ++;
	}
	
	private void playerDraw() {
		currentCard = drawCard();
		playerCards.add(currentCard);
		if (currentCard.getRank() < 10) {
			playerScore += currentCard.getRank(); 
		}
		cardsDrawn ++;
	}
	
	private Card drawCard() {
		currentCard = myDeck.getDeck().remove(0);
		
		if (myDeck.getDeck().size() == 0) {
			myDeck = new CardDeck();
		}
		
		return currentCard;
	}
	
	public List<Card> getPlayerCards() {
		return playerCards;
	}
	
	public List<Card> getBankerCards() {
		return bankerCards;
	}
	
	public int getPlayerScore() {
		return playerScore;
	}
	
	public int getBankerScore() {
		return bankerScore;
	}
}