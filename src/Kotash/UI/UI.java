package Kotash.UI;

import Kotash.Logic.Game;
import Kotash.UI.Helpers.Colors;

public class UI {
    public static void runGame() {
        startGame();

        Game game = new Game();
        int size = game.nCards();
        for (int i = 0; i < size; i++) {
            String[] cardInfo = game.getCardDescriptionAt(i).split("-");
            System.out.println(new Card(cardInfo[0], cardInfo[1]));
        }

        endGame();
    }

    private static void startGame() {
        System.out.println(Colors.BG_RED + Colors.BLACK + " Welcome to ELEVEN GAME " + Colors.RESET_COLOR);
        System.out.println();
    }

    private static void endGame() {
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
