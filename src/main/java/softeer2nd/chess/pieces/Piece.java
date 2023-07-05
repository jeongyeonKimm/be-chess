package softeer2nd.chess.pieces;

import java.util.Objects;

public class Piece {

    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final char WHITE_PAWN_REPRESENTATION = 'p';
    public static final char BLACK_PAWN_REPRESENTATION = 'P';
    public static final char WHITE_KNIGHT_REPRESENTATION = 'n';
    public static final char BLACK_KNIGHT_REPRESENTATION = 'N';
    public static final char WHITE_ROOK_REPRESENTATION = 'r';
    public static final char BLACK_ROOK_REPRESENTATION = 'R';
    public static final char WHITE_BISHOP_REPRESENTATION = 'b';
    public static final char BLACK_BISHOP_REPRESENTATION = 'B';
    public static final char WHITE_QUEEN_REPRESENTATION = 'q';
    public static final char BLACK_QUEEN_REPRESENTATION = 'Q';
    public static final char WHITE_KING_REPRESENTATION = 'k';
    public static final char BLACK_KING_REPRESENTATION = 'K';


    private String color;
    private String name;
    private char representation;

    private Piece() {
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public char getRepresentation() {
        return representation;
    }


    // == factory method == //
    public static Piece createPiece(String color, String name) {
        Piece piece = new Piece();
        piece.color = color;
        piece.name = name;
        return piece;
    }

    public static Piece createWhitePawn() {
        Piece piece = createPiece(WHITE_COLOR, "PAWN");
        piece.representation = WHITE_PAWN_REPRESENTATION;
        return piece;
    }

    public static Piece createBlackPawn() {
        Piece piece = createPiece(BLACK_COLOR, "PAWN");
        piece.representation = BLACK_PAWN_REPRESENTATION;
        return piece;
    }

    public static Piece createWhiteKnight() {
        Piece piece = createPiece(WHITE_COLOR, "KNIGHT");
        piece.representation = WHITE_KNIGHT_REPRESENTATION;
        return piece;
    }

    public static Piece createBlackKnight() {
        Piece piece = createPiece(BLACK_COLOR, "KNIGHT");
        piece.representation = BLACK_KNIGHT_REPRESENTATION;
        return piece;
    }

    public static Piece createWhiteRook() {
        Piece piece = createPiece(WHITE_COLOR, "ROOK");
        piece.representation = WHITE_ROOK_REPRESENTATION;
        return piece;
    }

    public static Piece createBlackRook() {
        Piece piece = createPiece(BLACK_COLOR, "ROOK");
        piece.representation = BLACK_ROOK_REPRESENTATION;
        return piece;
    }

    public static Piece createWhiteBishop() {
        Piece piece = createPiece(WHITE_COLOR, "BISHOP");
        piece.representation = WHITE_BISHOP_REPRESENTATION;
        return piece;
    }

    public static Piece createBlackBishop() {
        Piece piece = createPiece(BLACK_COLOR, "BISHOP");
        piece.representation = BLACK_BISHOP_REPRESENTATION;
        return piece;
    }

    public static Piece createWhiteQueen() {
        Piece piece = createPiece(WHITE_COLOR, "QUEEN");
        piece.representation = WHITE_QUEEN_REPRESENTATION;
        return piece;
    }

    public static Piece createBlackQueen() {
        Piece piece = createPiece(BLACK_COLOR, "QUEEN");
        piece.representation = BLACK_QUEEN_REPRESENTATION;
        return piece;
    }

    public static Piece createWhiteKing() {
        Piece piece = createPiece(WHITE_COLOR, "KING");
        piece.representation = WHITE_KING_REPRESENTATION;
        return piece;
    }

    public static Piece createBlackKing() {
        Piece piece = createPiece(BLACK_COLOR, "KING");
        piece.representation = BLACK_KING_REPRESENTATION;
        return piece;
    }

    public boolean isWhite() {
        return color.equals(WHITE_COLOR);
    }

    public boolean isBlack() {
        return Objects.equals(color, BLACK_COLOR);
    }
}