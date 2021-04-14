package Kotash ;

import elevengame.DataStore;
import elevengame.GameInterface;
import java.util.List;

/**
 *
 * @author pytel
 */
public class Elevengame implements GameInterface{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    private final String name = "Eleven game"; 

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int nCards() {
        return DataStore.getNCards(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getDeckSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCardDescriptionAt(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean anotherPlayIsPossible() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean playAndReplace(List<Integer> iSelectedCards) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isWon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
