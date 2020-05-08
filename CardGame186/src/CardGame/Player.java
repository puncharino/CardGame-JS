package CardGame;

import java.util.ArrayList;

public class Player {

    ArrayList<Card> hand = new ArrayList<>();
    private Deck mainDeck; // Should be the same as main deck in game

    // Creates a player with two initial cards in hand from the deck
    public Player (Deck mainDeck) {
        //for (int i = 0; i < 2; ++i) {
            this.mainDeck = mainDeck;
            //hit();
    }


    public void hit () {
        hand.add (mainDeck.drawCard());
    }

    // Hand total is dynamic; it will only change drastically when an Ace is present.
    public int getHandTotal () {
        int handTotal = 0;
        for (Card e : hand) {
            if (e.returnRankValue() >= 10) {
                handTotal += 10;
            } else if (e.returnRankValue() == 1) {

                if (handTotal+11 > 21) {
                    handTotal += 1;
                } else {
                    handTotal += 11;
                }
            } else { handTotal += e.returnRankValue(); }
        }
        return handTotal;
    }


    public ArrayList<Card> getHand() {
        return hand;
    }
}