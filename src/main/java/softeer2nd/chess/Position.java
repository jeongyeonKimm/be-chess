package softeer2nd.chess;

public class Position {
    private int x;
    private int y;

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

    @Override
    public String toString() {
        return ('a' + x) + "" + (y + 8);
    }
}