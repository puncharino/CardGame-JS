package yjohnson;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends Player {

    public boolean dealerTurn = false;

    public Dealer(Deck mainDeck) {
        super(mainDeck);
    }

    public void setDealerTurn(boolean dealerTurn) {
        this.dealerTurn = dealerTurn;
    }

    /**
     * Overrides the getHandTotal method. Only returns the value of the visible cards that the dealer has, simplifies
     * the Score element
     * @return the value of the visible card if it's not his turn yet, otherwise all of his cards
     */
    @Override
    public int getHandTotal() {
        if (!dealerTurn) {

            Card e = getHand().get(0);

            if (e.returnRankValue() >= 10) {
                return  10;
            } else if (e.returnRankValue() == 1) {
                if (super.getHandTotal()+11 > 21) {
                    return 1;
                } else {
                    return 11;
                }
            }
        }
        return super.getHandTotal();
    }

    /**
     * Overrides the getHand method. Will return two cards; one of which was drawn and the other which is effectively
     * a double-sided back image. When the dealer's turn is active, returns his hand as normal
     * @return a blank card and one card from his hand if not his turn, his hand otherwise
     */
    @Override
    public ArrayList<Card> getHand() {
        if (!dealerTurn) {
            ArrayList<Card> initialHand = super.getHand();
            ArrayList<Card> visibleHand = new ArrayList<>();
            visibleHand.add(initialHand.get(0);
            visibleHand.add(new Card(0, 0));
            return visibleHand;
        } else {
            return super.getHand();
        }
    }
}
