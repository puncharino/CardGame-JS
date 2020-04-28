package CardGame;

import java.util.Random;

public class BlackJack {
	static int playerBet = 0;
	static int playerWinnings = 0;
	static boolean playerTurn = true;
	static boolean dealerWin = false;
	static Player player = new Player();
	static Dealer dealer = new Dealer();
	static Random r = new Random();
	static Deck newDeck = new Deck(r);
	static boolean gameState = true;

	public static void Start() {

		while (dealer.getDealerValue() < 21 && !dealerWin && gameState) {
			if (dealer.getDealerValue() < 17) {
				dealer.hit(newDeck);
				
			} else if (dealer.getDealerValue() > player.getPlayerValue()) {
				dealerWin = true;
			} else if (dealer.getDealerValue() < player.getPlayerValue()) {
				dealerWin = false;
				gameState = false;
				
				playerWinnings = playerBet * 2;
			} else if (player.getPlayerValue() == dealer.getDealerValue()) {
				playerWinnings = playerBet;
			}
		}
		
	}

	public void bet(int bet) {
		playerBet = bet;
	}

	public static void playerHit() {
		if (playerTurn && player.getPlayerValue() < 21) {
			player.hit(newDeck);
		} else {
			playerTurn = false;
		}
	}

	public static void playerStand() {
		playerTurn = false;
	}

	public static int getPlayerScore() {
		return player.getPlayerValue();
	}

	public static int getDealerScore() {
		return dealer.getDealerValue();
	}

	public static void dealStartingCards() {
		newDeck.shuffle();
		player.dealInitialCards(newDeck);
		dealer.dealInitialCards(newDeck);
	}

	public static boolean isBust() {
		if (player.getPlayerValue() > 21) {
			return true;
		} else
			return false;

	}

}
