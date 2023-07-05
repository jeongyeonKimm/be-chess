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
        Piece piece = createPiece(WHITE, PAWN);
        return piece;
    }

    public static Piece createBlackPawn() {
        Piece piece = createPiece(BLACK, PAWN);
        return piece;
    }

    public static Piece createWhiteKnight() {
        Piece piece = createPiece(WHITE, KNIGHT);
        return piece;
    }

    public static Piece createBlackKnight() {
        Piece piece = createPiece(BLACK, KNIGHT);
        return piece;
    }

    public static Piece createWhiteRook() {
        Piece piece = createPiece(WHITE, ROOK);
        return piece;
    }

    public static Piece createBlackRook() {
        Piece piece = createPiece(BLACK, ROOK);
        return piece;
    }

    public static Piece createWhiteBishop() {
        Piece piece = createPiece(WHITE, BISHOP);
        return piece;
    }

    public static Piece createBlackBishop() {
        Piece piece = createPiece(BLACK, BISHOP);
        return piece;
    }

    public static Piece createWhiteQueen() {
        Piece piece = createPiece(WHITE, QUEEN);
        return piece;
    }

    public static Piece createBlackQueen() {
        Piece piece = createPiece(BLACK, QUEEN);
        return piece;
    }

    public static Piece createWhiteKing() {
        Piece piece = createPiece(WHITE, KING);
        return piece;
    }

    public static Piece createBlackKing() {
        Piece piece = createPiece(BLACK, KING);
        return piece;
    }

    public boolean isWhite() {
        return color.equals(WHITE);
    }

    public boolean isBlack() {
        return Objects.equals(color, BLACK);
    }
}