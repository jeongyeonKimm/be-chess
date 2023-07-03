package softeer2nd;

public class Pawn {

    private final String WHITE_COLOR = "white";
    private final String BLACK_COLOR = "black";
    private String color;

    public Pawn() {
        this.color = WHITE_COLOR;
    }

    public Pawn(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}