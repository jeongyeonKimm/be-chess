package softeer2nd.chess;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(String location) {
        this.x = location.charAt(0) - 'a';
        this.y = 8 - Character.getNumericValue(location.charAt(1));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String positionToString() {
        return (char) ('a' + this.getY()) + "" + (8 - this.getX());
    }
}