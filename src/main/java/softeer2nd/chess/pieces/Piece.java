package softeer2nd.chess.pieces;

import softeer2nd.chess.ChessView;
import softeer2nd.chess.Position;
import softeer2nd.chess.exception.BoardOutOfBounds;
import softeer2nd.chess.exception.SameColorPiece;

import java.util.Objects;

import static softeer2nd.chess.pieces.Piece.Color.*;
import static softeer2nd.chess.pieces.Piece.Color.BLACK;
import static softeer2nd.chess.pieces.Piece.Type.*;

public class Piece {
    public enum Color {
        WHITE, BLACK, NO_COLOR;
    }

    public enum Type {
        PAWN('p', 1.0),
        KNIGHT('n', 2.5),
        ROOK('r', 5.0),
        BISHOP('b', 3.0),
        QUEEN('q', 9.0),
        KING('k', 0.0),
        NO_PIECE('.', 0.0);

        private char representation;
        private double defaultPoint;

        Type(char representation, double defaultPoint) {
            this.representation = representation;
            this.defaultPoint = defaultPoint;
        }

        public char getRepresentation() {
            return representation;
        }

        public double getDefaultPoint() {
            return defaultPoint;
        }
    }

    private Color color;
    private Type type;
    private Position position;

    private Piece() {
    }

    private Piece(Color color, Type type, Position position) {
        this.color = color;
        this.type = type;
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public Position getPosition() {
        return position;
    }

    // == factory method == //
    public static Piece createPiece(Color color, Type type, Position position) {
        return new Piece(color, type, position);
    }

    public static Piece createBlank(Position position) {
        return createPiece(NO_COLOR, NO_PIECE, position);
    }

    private static Piece createWhite(Type type, Position position) {
        return createPiece(WHITE, type, position);
    }

    private static Piece createBlack(Type type, Position position) {
        return createPiece(BLACK, type, position);
    }

    public static Piece createWhitePawn(Position position) {
        return createWhite(PAWN, position);
    }

    public static Piece createBlackPawn(Position position) {
        return createBlack(PAWN, position);
    }

    public static Piece createWhiteKnight(Position position) {
        return createWhite(KNIGHT, position);
    }

    public static Piece createBlackKnight(Position position) {
        return createBlack(KNIGHT, position);
    }

    public static Piece createWhiteRook(Position position) {
        return createWhite(ROOK, position);
    }

    public static Piece createBlackRook(Position position) {
        return createBlack(ROOK, position);
    }

    public static Piece createWhiteBishop(Position position) {
        return createWhite(BISHOP, position);
    }

    public static Piece createBlackBishop(Position position) {
        return createBlack(BISHOP, position);
    }

    public static Piece createWhiteQueen(Position position) {
        return createWhite(QUEEN, position);
    }

    public static Piece createBlackQueen(Position position) {
        return createBlack(QUEEN, position);
    }

    public static Piece createWhiteKing(Position position) {
        return createWhite(KING, position);
    }

    public static Piece createBlackKing(Position position) {
        return createBlack(KING, position);
    }

    public boolean isWhite() {
        return color.equals(WHITE);
    }

    public boolean isBlack() {
        return Objects.equals(color, BLACK);
    }

    public void changePosition(Position position) {
        this.position = position;
    }

    public void moveKing(String target, ChessGame chessGame) {
        Position sourcePosition = this.position;
        Position targetPosition = new Position(target);

        verifyChessBoardBound(sourcePosition, targetPosition);
        verifySameColorPiece(this, chessGame.findPiece(target));

        chessGame.move(this.position.toString(), target);
    }

    private static void verifySameColorPiece(Piece source, Piece target) {
        if (source.getColor() == target.getColor()) {
            throw new SameColorPiece("이동하려는 위치에 같은 편의 기물이 있습니다.");
        }
    }

    private static void verifyChessBoardBound(Position sourcePosition, Position targetPosition) {
        if (Math.abs(sourcePosition.getX() - targetPosition.getX()) > 1 ||
                Math.abs(sourcePosition.getY() - targetPosition.getY()) > 1) {
            throw new BoardOutOfBounds("체스판 밖으로 이동할 수 없습니다.");
        }
    }
}