package softeer2nd.chess.pieces;

import softeer2nd.chess.ChessView;
import softeer2nd.chess.Position;
import softeer2nd.chess.exception.BoardOutOfBounds;
import softeer2nd.chess.exception.IllegalDirection;
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

    public void moveKing(Piece target, ChessGame chessGame) {
        Position targetPosition = target.position;

        verifyChessBoardBound(targetPosition);
        verifySameColorPiece(chessGame.findPiece(targetPosition.toString()));

        chessGame.move(this.position.toString(), targetPosition.toString());
    }

    public void moveQueen(Piece target, ChessGame chessGame) {
        Position targetPosition = target.getPosition();

        if (position.getX() == targetPosition.getX() &&
                position.getY() == targetPosition.getY()) {
            chessGame.move(position.toString(), target.toString());
            return;
        }

        int dx = ((targetPosition.getX() - position.getX()) > 0
                ? 1
                : (targetPosition.getX() - position.getX() == 0 ? 0 : -1));
        int dy = ((targetPosition.getY() - position.getY()) > 0
                ? 1
                : (targetPosition.getY() - position.getY() == 0 ? 0 : -1));

        int nx = position.getX() + dx;
        int ny = position.getY() + dy;

        verifyQueenDirection(targetPosition);
        verifySameColorPiece(target);
        this.position = targetPosition;
        moveQueen(chessGame.findPiece(new Position(nx, ny).toString()), chessGame);
    }

    private void verifyChessBoardBound(Position targetPosition) {
        if (Math.abs(position.getX() - targetPosition.getX()) > 1 ||
                Math.abs(position.getY() - targetPosition.getY()) > 1) {
            throw new BoardOutOfBounds("체스판 밖으로 이동할 수 없습니다.");
        }
    }

    private void verifyQueenDirection(Position targetPosition) {
        if (position.getX() == targetPosition.getX() || position.getY() == targetPosition.getY()) {
            return;
        }

        if (position.getX() + 1 == targetPosition.getX() && position.getY() + 1 == targetPosition.getY()) {
            return;
        }

        throw new IllegalDirection("Queen이 이동할 수 없는 방향 입니다.");
    }

    private void verifySameColorPiece(Piece target) {
        if (this.color == target.getColor()) {
            throw new SameColorPiece("이동하려는 위치에 같은 편의 기물이 있습니다.");
        }
    }
}