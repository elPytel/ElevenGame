package Kotash.UI;

import Kotash.Logic.Game;
import Kotash.UI.Helpers.Colors;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {
    
    public static Scanner sc = new Scanner(System.in);
    
    public static void runGame() {
        startGame();

        Game game = new Game();
        int size = game.nCards();
        for (int i = 0; i < size; i++) {
            String[] cardInfo = game.getCardDescriptionAt(i).split("-");
            System.out.println(new Card(cardInfo[0], cardInfo[1]));
        }
        getNextMove();
        endGame();
    }

    private static void startGame() {
        System.out.println(Colors.BG_RED + Colors.BLACK + " Welcome to ELEVEN GAME " + Colors.RESET_COLOR);
        System.out.println();
    }
    
    /**
     * Read input to string.
     * @return 
     */
    private static String readInput() {
        return sc.nextLine();
    }
    
    /**
     * Parse string input into integers.
     * @return 
     */
    private static List<Integer> parseInput(String inputString) {
        String[] numbersInString = inputString.split(" ");
        List<Integer> numbers = new ArrayList();
        for (String numberString : numbersInString) {
            numbers.add(Integer.parseInt(numberString));
        }
        return numbers;
    }
    
    public static boolean validMoveLen (int len) {
        return len == 2 || len == 3;
    }
    
    private static List<Integer> getNextMove () {
        int inputLen = 0;
        List<Integer> move = new ArrayList();
        String inputString;
        while (!validMoveLen(inputLen)) {
            System.out.format("Type your move: ");
            inputString = readInput();
            move = parseInput(inputString);
            inputLen = move.size();
            if (!validMoveLen(inputLen)) {
                System.out.format("Invalid input, try once more... \n");
            }
        }
        return move;
    }

    private static void endGame() {
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
