package CardGame;


public class BlackJack {

    /* BlackJack can be static; there will be one player and one dealer at any given point in time (for version 0.1) */
    private static Deck deckBJ = new Deck();
    private static Player p1 = new Player(deckBJ);
    private static Dealer dealer = new Dealer(deckBJ);

    public static boolean gameState = true;
    public static boolean dealerWin = false;


    /* A new instance of the game BlackJack */
    public BlackJack() {
        restartBJ();
    }

    public static boolean hasBlackJack (Player entity) {
        if (entity.getHandTotal() == 21) {
            return true;
        }
        return false;
    }

    public static boolean hasBusted (Player entity) {
        if (entity.getHandTotal() > 21) {
            return true;
        }
        return false;
    }

    public static void restartBJ () {
        deckBJ.reset();
        deckBJ.shuffle();

        /* The player and dealer must draw two cards at the start of the game. */
        for (int i = 0; i < 2; ++i) {
            /* Player first, dealer second */
            p1.hit();
            dealer.hit();
        }
    }

    public static Player getPlayer() {
        return p1;
    }
    public static Dealer getDealer() {
        return dealer;
    }
}
