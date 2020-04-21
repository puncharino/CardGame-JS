package CardGame186;

import java.util.ArrayList;

public class Dealer {
	private int dealerCards = 0;
	private ArrayList<Card> hand = new ArrayList<Card>();
	public Dealer() {
	}
	public static void main(String[] args) {
	}
	public int getDealerValue() {
		return dealerCards;
	}
	public void drawCards(Deck newDeck) {
		Card drawn = newDeck.drawCard();
		if (drawn.returnRankValue() == 1 && dealerCards < 11) {
			dealerCards += 11;
		}
		else if (drawn.returnRankValue() == 1 && dealerCards >= 11){
			dealerCards += 1;
		}
		else if (drawn.returnRankValue() > 10) {
			dealerCards += 10;
		}
		else {
		dealerCards += drawn.returnRankValue();
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
