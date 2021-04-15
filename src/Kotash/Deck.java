package Kotash;

import Kotash.Card;
import elevengame.DataStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author pytel
 */
public class Deck {

    private final boolean DEBUG = true;
    
    private static final int SIZE = 52;
    private List deck;

    public Deck() {
        
        Card[] cards = Deck.generateDeck();
        Integer[] randomIndexs = Deck.genrerateRandomIndexs();
        // Colections Shuffle
        shuffleCards(cards, randomIndexs);
    }
    
    private static Card[] generateDeck () {
        Card card;
        List<Card> cards = new ArrayList();
        int[] points = DataStore.loadNPoints();
        String[] values = DataStore.loadValues();
        for (String symbol : DataStore.loadSymbols()) {
            for (int i = 0 ; i < values.length; i++) {
                card = new Card(symbol, values[i], points[i]);
                cards.add(card);
            }
        }
        return (Card[]) cards.toArray();
    }
    
    private static Integer[] genrerateRandomIndexs () {
        
        // vytvori pole indexu 1:SIZE
        List<Integer> sortedIndexs = new ArrayList();
        for (int i = 0 ; i < Deck.SIZE; i++) {
            sortedIndexs.add(i);
        }
        
        // zamicha indexi
        Random ran = new Random();
        List<Integer> shuffledIndexs = new ArrayList();
        int index, position;
        while (!sortedIndexs.isEmpty()) {
            position = ran.nextInt(sortedIndexs.size());
            index = sortedIndexs.remove(position);
            shuffledIndexs.add(index);
        }
        return (Integer[]) shuffledIndexs.toArray();
    }
    
    private void shuffleCards (Card[] cards, Integer[] randomIndexs) {
        Card[] shuffledCard = new Card[Deck.SIZE];
        int index;
        for (int i = 0; i < Deck.SIZE; i++) {
            index = randomIndexs[i];
            shuffledCard[i] = cards[index];
        }
        
        this.deck = Arrays.asList(shuffledCard);
    }
    
    public Card getCard() {
        return (Card) this.deck.remove(this.deck.size()-1);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}