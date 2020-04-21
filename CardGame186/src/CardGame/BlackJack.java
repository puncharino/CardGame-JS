package CardGame186;
import java.util.Random;

public class BlackJack {
	public static void main(String[] args) {	
	Player player = new Player();
	Dealer dealer = new Dealer();
	Random r = new Random(123);
	Deck newDeck = new Deck(52, r);
	boolean playerTurn = true;
	player.dealInitialCards(newDeck);
	dealer.dealInitialCards(newDeck);
	System.out.println(player.getPlayerValue());
	System.out.println(dealer.getDealerValue());
	 while (newDeck.returnDeckSize() > 0 && player.getPlayerValue() < 22 && dealer.getDealerValue() < 22 && dealer.getDealerValue() != 21) {
		 if (playerTurn && player.getPlayerValue() != 21) {
		player.hit(newDeck);
		playerTurn = false;
		System.out.println(player.getPlayerValue());
	 }
		 else if (!playerTurn && dealer.getDealerValue() < 17){
		dealer.hit(newDeck);
		playerTurn = true;
		System.out.println(dealer.getDealerValue());
		}
	  }
	}
}
