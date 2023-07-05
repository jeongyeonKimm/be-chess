package softeer2nd.chess.pieces;

import java.util.Objects;

public class Piece {
    public enum Color {
        WHITE, BLACK, NO_COLOR;
    }

    public enum Type {
        PAWN('p'),
        KNIGHT('k'),
        ROOK('K'),
        BISHOP('b'),
        QUEEN('q'),
        KING('k'),
        NO_PIECE('.');

        private char representation;

        Type(char representation) {
            this.representation = representation;
        }

        public char getRepresentation() {
            return representation;
        }
    }


    private Color color;
    private Type type;

    private Piece() {
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    // == factory method == //
    public static Piece createPiece(Color color, Type type) {
        Piece piece = new Piece();
        piece.color = color;
        piece.type = type;
        return piece;
    }

    public static Piece createWhitePawn() {
        Piece piece = createPiece(Color.WHITE, Type.PAWN);
        return piece;
    }

    public static Piece createBlackPawn() {
        Piece piece = createPiece(Color.BLACK, Type.PAWN);
        return piece;
    }

    public static Piece createWhiteKnight() {
        Piece piece = createPiece(Color.WHITE, Type.KNIGHT);
        return piece;
    }

    public static Piece createBlackKnight() {
        Piece piece = createPiece(Color.BLACK, Type.KNIGHT);
        return piece;
    }

    public static Piece createWhiteRook() {
        Piece piece = createPiece(Color.WHITE, Type.ROOK);
        return piece;
    }

    public static Piece createBlackRook() {
        Piece piece = createPiece(Color.BLACK, Type.ROOK);
        return piece;
    }

    public static Piece createWhiteBishop() {
        Piece piece = createPiece(Color.WHITE, Type.BISHOP);
        return piece;
    }

    public static Piece createBlackBishop() {
        Piece piece = createPiece(Color.BLACK, Type.BISHOP);
        return piece;
    }

    public static Piece createWhiteQueen() {
        Piece piece = createPiece(Color.WHITE, Type.QUEEN);
        return piece;
    }

    public static Piece createBlackQueen() {
        Piece piece = createPiece(Color.BLACK, Type.QUEEN);
        return piece;
    }

    public static Piece createWhiteKing() {
        Piece piece = createPiece(Color.WHITE, Type.KING);
        return piece;
    }

    public static Piece createBlackKing() {
        Piece piece = createPiece(Color.BLACK, Type.KING);
        return piece;
    }

    public boolean isWhite() {
        return color.equals(Color.WHITE);
    }

    public boolean isBlack() {
        return Objects.equals(color, Color.BLACK);
    }
}