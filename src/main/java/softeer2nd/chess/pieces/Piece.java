package softeer2nd.chess.pieces;

import softeer2nd.chess.Direction;
import softeer2nd.chess.Position;

import java.util.List;

import static softeer2nd.chess.pieces.Color.*;

abstract public class Piece {

    private final Color color;
    private final Type type;
    private Position position;

    public Piece(Color color, Type type, Position position) {
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

    public boolean isWhite() {
        return this.color == WHITE;
    }

    public boolean isBlack() {
        return this.color == BLACK;
    }

    abstract public Direction verifyMovePosition(Piece target);
    abstract public List<Position> getMovePath(Direction direction, Position target);

    public static Piece createPiece(Color color, Type type, Position position) {
        if (color == NO_COLOR) {
            return Blank.createBlank(position);
        }

        boolean flag = color == WHITE;

        switch(type) {
            case PAWN:
                return flag ? Pawn.createWhitePawn(position) : Pawn.createBlackPawn(position);
            case KNIGHT:
                return flag ? Knight.createWhiteKnight(position) : Knight.createBlackKnight(position);
            case ROOK:
                return flag ? Rook.createWhiteRook(position) : Rook.createBlackRook(position);
            case BISHOP:
                return flag ? Bishop.createWhiteBishop(position) : Bishop.createBlackBishop(position);
            case QUEEN:
                return flag ? Queen.createWhiteQueen(position) : Queen.createBlackQueen(position);
            case KING:
                return flag ? King.createWhiteKing(position) : King.createBlackKing(position);
            default:
                return Blank.createBlank(position);
        }
    }

    public void setNewPosition(Position newPosition) {
        this.position = newPosition;
    }
}