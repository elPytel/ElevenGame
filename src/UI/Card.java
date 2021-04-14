package UI;

public class Card {
    String label;
    String value;
    boolean red;

    public Card(String label, String value) {
        this.label = convertLabels(label);
        this.value = value;
        this.red = label.equals("diamonds") || label.equals("hearts");
    }

    private String convertLabels(String labelName) {
        return switch (labelName) {
            case "hearts" -> "\u2665";
            case "diamonds" -> "\u2666";
            case "clubs" -> "\u2663";
            case "spades" -> "\u2660";
            default -> "\u2665";
        };
    }

    @Override
    public String toString() {
        return (this.red ? Colors.RED : Colors.BLUE) +
                String.format(
                        """
                                %c%c%c%c%c%c%c
                                %c%s%s%s%s%s%c
                                %c%s%s%s%s%s%c
                                %c%c%c%c%c%c%c
                                """,
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
