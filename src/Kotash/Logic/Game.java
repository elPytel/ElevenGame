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
    
    private final String name = "Eleven game"; 
    private Deck deck;
    private Card[] table = new Card[9];

    public Game() {
        this.deck = new Deck();
        for (int i = 0; i < table.length; i++) {
            this.table[i] = this.deck.getCard();
        }
    }
    
    @Override
    public String getName() {
        return this.name;
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
        //TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private boolean JKQExist() {
        String[] sTriple = DataStore.getTriple();
        boolean[] bTriple = {false, false, false};
        List<String> triple = Arrays.asList(sTriple);
        int index;
        for (Card card : table) {
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
        return this.table[index].toString();
    }

    @Override
    public boolean anotherPlayIsPossible() {
        return JKQExist() || sumElevenExist();
    }

    @Override
    public boolean playAndReplace(List<Integer> iSelectedCards) {
        throw new UnsupportedOperationException("Not supported yet.");
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
