package CardGame;

import java.util.ArrayList;

public class Player {
    public int numHit = -2;
    public final BlackJack.origin status = BlackJack.origin.PLAYER;

    ArrayList<Card> hand = new ArrayList<>();
    private final Deck mainDeck; // Should be the same as main deck in game

    // Creates a player with two initial cards in hand from the deck
    public Player (Deck mainDeck) {
        this.mainDeck = mainDeck;
    }


    public void hit () {
        hand.add (mainDeck.drawCard());
        ++numHit;
    }

    // Hand total is dynamic; it will only change drastically when an Ace is present.
    public int getHandTotal () {
        int handTotal = 0;
        int aceCount = 0;
        for (Card e : hand) {
            if (e.returnRankValue() >= 10) {
                handTotal += 10;
            } else if (e.returnRankValue() == 1) {
                ++aceCount;
            } else { handTotal += e.returnRankValue(); }
        }

        /* Calculate the worth of aces after all other cards have been counted */
        for (int i = 0; i < aceCount; ++i) {
            if (handTotal+11 > 21) {
                handTotal += 1;
            } else {
                handTotal += 11;
            }
        }

        return handTotal;
    }


    public ArrayList<Card> getHand() {
        return hand;
    }

    public ArrayList getHandRanks () {
        ArrayList<String> ranks = new ArrayList<>();
        for (Card o : getHand()) {
            ranks.add(o.returnRank());
        }
        return ranks;
    }
}