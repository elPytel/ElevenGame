package Kotash.Logic ;

import elevengame.DataStore;
import elevengame.GameInterface;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author pytel
 */
public class Game implements GameInterface{
    
    private static final String name = "Eleven game"; 
    private static final int eleven = 11;
    private Deck deck;
    private Card[] table = new Card[nCards()];

    public Game() {
        this.deck = new Deck();
        for (int i = 0; i < table.length; i++) {
            this.table[i] = this.deck.getCard();
        }
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int nCards() {
        return DataStore.getNCards();
    }

    @Override
    public int getDeckSize() {
        return this.deck.getSize();
    }

    private boolean sumElevenExist() {
        for (int i = 0; i < nCards(); i++) {
            for (int j = i; j < nCards(); i++) {
                if (table[i].getPoint() + table[j].getPoint() == eleven) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean JKQExist(Card[] array) {
        String[] sTriple = DataStore.getTriple();
        boolean[] bTriple = {false, false, false};
        List<String> triple = Arrays.asList(sTriple);
        int index;
        for (Card card : array) {
            index = triple.indexOf(card.getValue());
            // karta je z triplu
            if (index != -1) {
                bTriple[index] = true;
            }
        }
        // nalezl jsem vsechny karty?
        return Arrays.asList(bTriple).indexOf(false) == -1;
    }
    
    @Override
    public String getCardDescriptionAt(int index) {
        return this.table[index] == null ? null : this.table[index].toString();
    }

    @Override
    public boolean anotherPlayIsPossible() {
        return JKQExist(table) || sumElevenExist();
    }
    
    public boolean isEleven(Card c1, Card c2) {
        return (c1.getPoint() + c2.getPoint()) == eleven;
    }
    

    @Override
    public boolean playAndReplace(List<Integer> iSelectedCards) {
        // valid
        for (int i : iSelectedCards) {
            if (i < 0 || i > nCards()) {
                throw new IllegalArgumentException("Index: " + i);
            }
        }
        
        // test
        switch (iSelectedCards.size()) {
            case 2:
                if (!isEleven(table[iSelectedCards.get(0)], table[iSelectedCards.get(1)])) {
                    return false;
                }
                break;
            case 3:
                Card[] selectedCards = new Card[3];
                selectedCards[0] = this.table[iSelectedCards.get(0)];
                selectedCards[1] = this.table[iSelectedCards.get(1)];
                selectedCards[2] = this.table[iSelectedCards.get(2)];
                if (!JKQExist(selectedCards)) {
                    return false;
                }
                break;
            default:
                return false;
        }
        
        // execute
        for (int i : iSelectedCards) {
            table[i] = deck.getCard();
        }
        return true;
    }

    @Override
    public boolean isWon() {
        return this.deck.getSize() == 0;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game g = new Game();
        System.out.format("Name: %s \n", g.getName());
        System.out.format("Desk size: %d \n", g.nCards());
        
        // desk
        for (int i = 0; i < g.nCards(); i++) {
            System.out.format("Card: %s \n", g.getCardDescriptionAt(i));
        }
    }
}