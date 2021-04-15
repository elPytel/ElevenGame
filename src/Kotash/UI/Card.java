package Kotash.UI;

import Kotash.UI.Helpers.Colors;
import Kotash.UI.Helpers.ExtendedAscii;

import java.util.Locale;

public class Card {
    String label;
    String value;
    boolean red;

    public Card(String label, String value) {
        this.label = convertLabels(label);
        this.value = convertValues(value);
        this.red = label.equals("diamonds") || label.equals("hearts");
    }

    private String convertLabels(String labelName) {
        switch (labelName) {
            case "diamonds": return "\u2666";
            case "clubs": return "\u2663";
            case "spades": return "\u2660";
            default: return "\u2665";
        }
    }

    private String convertValues(String value) {
        if (value.length() > 2) {
            return Character.toString(value.toUpperCase().toCharArray()[0]);
        }
        return value;
    }

    @Override
    public String toString() {
        return (this.red ? Colors.RED : Colors.BLUE) +
                String.format(
                                "%c%c%c%c%c%c%c\n" +
                                "%c%s%s%s%s%s%c\n" +
                                "%c%s%s%s%s%s%c\n" +
                                "%c%c%c%c%c%c%c\n",
                        ExtendedAscii.getAscii(200),
                        ExtendedAscii.getAscii(204),
                        ExtendedAscii.getAscii(204),
                        ExtendedAscii.getAscii(204),
                        ExtendedAscii.getAscii(204),
                        ExtendedAscii.getAscii(204),
                        ExtendedAscii.getAscii(186),

                        ExtendedAscii.getAscii(185),
                        " ",
                        " ",
                        value,
                        value.length() > 1 ? "" : " ",
                        " ",
                        ExtendedAscii.getAscii(185),

                        ExtendedAscii.getAscii(185),
                        " ",
                        " ",
                        label,
                        " ",
                        " ",
                        ExtendedAscii.getAscii(185),

                        ExtendedAscii.getAscii(199),
                        ExtendedAscii.getAscii(204),
                        ExtendedAscii.getAscii(204),
                        ExtendedAscii.getAscii(204),
                        ExtendedAscii.getAscii(204),
                        ExtendedAscii.getAscii(204),
                        ExtendedAscii.getAscii(187)
                ) + Colors.RESET_COLOR;
    }
}
