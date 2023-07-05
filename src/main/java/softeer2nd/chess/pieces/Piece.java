package softeer2nd.chess.pieces;

import java.util.Objects;

import static softeer2nd.chess.pieces.Piece.Color.*;
import static softeer2nd.chess.pieces.Piece.Color.BLACK;
import static softeer2nd.chess.pieces.Piece.Type.*;

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
        return createWhite(PAWN);
    }

    public static Piece createBlackPawn() {
        return createBlack(PAWN);
    }

    public static Piece createWhiteKnight() {
        return createWhite(KNIGHT);
    }

    public static Piece createBlackKnight() {
        return createBlack(KNIGHT);
    }

    public static Piece createWhiteRook() {
        return createWhite(ROOK);
    }

    public static Piece createBlackRook() {
        return createBlack(ROOK);
    }

    public static Piece createWhiteBishop() {
        return createWhite(BISHOP);
    }

    public static Piece createBlackBishop() {
        return createBlack(BISHOP);
    }

    public static Piece createWhiteQueen() {
        return createWhite(QUEEN);
    }

    public static Piece createBlackQueen() {
        return createBlack(QUEEN);
    }

    public static Piece createWhiteKing() {
        return createWhite(KING);
    }

    public static Piece createBlackKing() {
        return createBlack(KING);
    }

    public static Piece createBlank() {
        return createPiece(NO_COLOR, NO_PIECE);
    }

    private static Piece createWhite(Type type) {
        return createPiece(WHITE, type);
    }

    private static Piece createBlack(Type type) {
        return createPiece(BLACK, type);
    }

    public boolean isWhite() {
        return color.equals(WHITE);
    }

    public boolean isBlack() {
        return Objects.equals(color, BLACK);
    }
}