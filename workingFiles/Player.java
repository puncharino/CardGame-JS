package CardGame;

import java.util.ArrayList;

public class Player {
	private int playerCards = 0;
	private ArrayList<Card> hand = new ArrayList<Card>();
	public Player() {
	}
	public static void main(String[] args) {
	}
	public int getPlayerValue(){
		return playerCards;
	}
	public void drawCards(Deck newDeck) {
		Card drawn = newDeck.drawCard();
		if (drawn.returnRankValue() == 1 && playerCards < 11) {
			playerCards += 11;
		}
		else if (drawn.returnRankValue() == 1 && playerCards >= 11){
			playerCards += 1;
		}
		else if (drawn.returnRankValue() > 10) {
			playerCards += 10;
		}
		else {
		playerCards += drawn.returnRankValue();
		}
		hand.add(drawn);
	}
	public int ace(boolean oneOrEleven) {
		if (oneOrEleven == true){
			return 1;	
		}
		else {
			return 11;
		}
	}
	public void dealInitialCards(Deck newDeck) {
		drawCards(newDeck);
		drawCards(newDeck);
	}
	public void hit(Deck newDeck){
		drawCards(newDeck);
	}
}
