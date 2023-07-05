package softeer2nd.chess.pieces;

public class Piece {

    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final char WHITE_PAWN_REPRESENTATION = 'p';
    public static final char BLACK_PAWN_REPRESENTATION = 'P';

    private String color;
    private String name;
    private char representation;

    private Piece() {
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }


    public static Piece createPiece(String color, String name) {
        Piece piece = new Piece();
        piece.color = color;
        piece.name = name;
        return piece;
    }

    public static Piece createWhitePawn() {
        Piece white = createPiece(WHITE_COLOR, "pawn");
        white.representation = WHITE_PAWN_REPRESENTATION;
        return white;
    }

    public static Piece createBlackPawn() {
        Piece black = createPiece(BLACK_COLOR, "pawn");
        black.representation = BLACK_PAWN_REPRESENTATION;
        return black;
    }
}