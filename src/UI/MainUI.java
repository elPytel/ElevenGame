package UI;

public class MainUI {
    public static void main(String[] args) {
        startGame();

        System.out.println(new Card("diamonds", "1"));
        System.out.println(new Card("hearts", "J"));
        System.out.println(new Card("clubs", "10"));
        System.out.println(new Card("spades", "Q"));

        endGame();
    }

    public static void startGame() {
        System.out.println(Colors.BG_RED + Colors.BLACK + " Welcome to ELEVEN GAME " + Colors.RESET_COLOR);
        System.out.println();
    }

    public static void endGame() {
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
