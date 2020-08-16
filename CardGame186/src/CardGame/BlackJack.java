package CardGame;

public class BlackJack {

    /* BlackJack can be static; there will be one player and one dealer at any given point in time (for version 0.1) */
    private static final Deck deckBJ = new Deck();
    private static final Player p1 = new Player(deckBJ);
    private static final Dealer dealer = new Dealer(deckBJ);

    public enum origin {
        PLAYER, DEALER, SYSTEM
    }

    // TODO implement multiple hands with multiple Player instances


    /* A new instance of the game BlackJack */

    public static int playerHit (Player p) {
        GameLog.addEvent("Hit", p.status, true);
        p.hit();
        return p.numHit;
    }

    public static boolean hasBlackJack (Player entity) {
        return entity.getHandTotal() == 21;

    }

    public static boolean hasBusted (Player entity) {
        return entity.getHandTotal() > 21;
    }

    public static void restartBJ () {
        GameLog.addEvent("Shuffling the deck.", origin.SYSTEM, true);
        deckBJ.reset();
        deckBJ.shuffle();

        GameLog.addEvent("Dealing starting cards.", origin.SYSTEM, false);
        /* The player and dealer must draw two cards at the start of the game. */
        for (int i = 0; i < 2; ++i) {
            /* Player first, dealer second */
            p1.hit();
            dealer.hit();
        }
    }

    public static boolean dealerWin(Player p) {
        GameLog.addEvent("Player: " + p.getHandTotal() + ", Dealer: "+ dealer.getHandTotal(), origin.SYSTEM, false);
        return dealer.getHandTotal() > p.getHandTotal();
    }

    public static Player getPlayer() {
        return p1;
    }
    public static Dealer getDealer() {
        return dealer;
    }
}
