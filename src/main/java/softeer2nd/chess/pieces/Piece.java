package softeer2nd.chess.pieces;

import softeer2nd.chess.Board;
import softeer2nd.chess.Direction;
import softeer2nd.chess.Position;

import java.util.ArrayList;
import java.util.List;

import static softeer2nd.chess.pieces.Color.*;
import static softeer2nd.chess.pieces.Type.*;

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

    public void setNewPosition(Position newPosition) {
        this.position = newPosition;
    }

    public boolean isWhite() {
        return this.color == WHITE;
    }

    public boolean isBlack() {
        return this.color == BLACK;
    }

    public boolean isColor(Color color) {
        return this.color == color;
    }

    public boolean isType(Type type) {
        return this.type == type;
    }

    public boolean isRank(int rankNum) {
        return this.position.getY() == rankNum;
    }

    public static Piece createPiece(Color color, Type type, Position position) {
        if (type == NO_PIECE) {
            return Blank.createBlank(position);
        }

        boolean flag = (color == WHITE);

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
    abstract public Direction verifyMovePosition(Piece target);

    abstract public Direction verifyDirection(List<Direction> directions, Position target);

    public List<Position> getMovePath(Direction direction, Position target) {
        List<Position> movePath = new ArrayList<>();

        int dx = direction.getXDegree();
        int dy = direction.getYDegree();

        for (int moveCount = 1; moveCount <= Board.BOARD_LENGTH; moveCount++) {
            int nx = this.getPosition().getX() + dx * moveCount;
            int ny = this.getPosition().getY() + -1 * dy * moveCount;
            Position position = new Position(nx, ny);
            if (position.equals(target)) {
                break;
            }
            movePath.add(position);
        }

        return movePath;
    }
}