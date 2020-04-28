package CardGame186;
import java.util.Random;

public class BlackJack {
	int playerBet = 0;
	int playerWinnings = 0;
	boolean playerTurn = true;
	boolean dealerWin = false;
	Player player = new Player();
	Dealer dealer = new Dealer();
	Random r = new Random(2332);
	Deck newDeck = new Deck(52, r);
	
	
	public BlackJack() {	
	player.dealInitialCards(newDeck);
	dealer.dealInitialCards(newDeck);
	
	while (newDeck.returnDeckSize() > 0 && dealer.getDealerValue() < 21) {
		if (!playerTurn && dealer.getDealerValue() < 17){
		dealer.hit(newDeck);
	 	}
		 else if (player.getPlayerValue() < 21 && dealer.getDealerValue() > player.getPlayerValue()) {
			 dealerWin = true;
		 }
		 else if (player.getPlayerValue() <= 21 && dealer.getDealerValue() < player.getPlayerValue()) {
			 dealerWin = false;
			 playerWinnings = playerBet*2;
		 }
		 else if (player.getPlayerValue() == dealer.getDealerValue()) {
			 playerWinnings = playerBet;
		 }
		}
	}
	
	public void bet(int bet){
		playerBet = bet;
	}
	public void playerHit() {
		 if (playerTurn && player.getPlayerValue() < 21) {
				player.hit(newDeck);
			 }
		 else {
			 playerTurn = false;
		 }
	}
	public void playerStand() {
		playerTurn = false;
	}
}
