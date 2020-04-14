package CardGame186;

public class BlackJack {
	public static void main(String[] args) {	
	BlackJack blackJack = new BlackJack();
	Deck newDeck = new Deck();
	int dealerCards = 0;
	int playerCards = 0;
	blackJack.dealInitialCards(dealerCards, playerCards, newDeck);
	 while (newDeck.returnDeckSize() > 0 && playerCards < 22 && dealerCards < 22 && dealerCards != 21) {
		 //Insert game instructions here
	 }
	}
	public void drawCards(int f, Deck newDeck) {
		int cardValue = newDeck.drawCard().returnRankValue();
		if (cardValue == 1 && f < 11) {
			f += 11;
		}
		else {
			f += 1;
		}
	}
	public int ace(boolean oneOrEleven) {
		if (oneOrEleven == true){
			return 1;	
		}
		else {
			return 11;
		}
	}
	public void dealInitialCards(int dealerCards, int playerCards, Deck newDeck) {
		drawCards(dealerCards, newDeck);
		drawCards(dealerCards, newDeck);
		drawCards(playerCards, newDeck);
		drawCards(playerCards, newDeck);
	}
	public void hit(int f, Deck newDeck){
		drawCards(f, newDeck);
	}
	
}
