package softeer2nd.chess.pieces;

import softeer2nd.chess.Direction;
import softeer2nd.chess.Position;
import softeer2nd.chess.exception.IllegalDirection;

import java.util.List;

import static softeer2nd.chess.pieces.Color.BLACK;
import static softeer2nd.chess.pieces.Color.WHITE;
import static softeer2nd.chess.pieces.Type.ROOK;

public class Rook extends Piece {

    private Rook(Color color, Type type, Position position) {
        super(color, type, position);
    }

    public static Piece createWhiteRook(Position position) {
        return new Rook(WHITE, ROOK, position);
    }

    public static Piece createBlackRook(Position position) {
        return new Rook(BLACK, ROOK, position);
    }

    @Override
    public Direction verifyMovePosition(Piece target) {
        List<Direction> directions = Direction.linearDirection();
        return verifyDirection(directions, target.getPosition());
    }

    @Override
    public Direction verifyDirection(List<Direction> directions, Position target) {
        int dx = target.getX() - getPosition().getX();
        int dy = target.getY() - getPosition().getY();

        for (Direction d : directions) {
            if ((dx == 0 && d.getXDegree() == dx && d.getYDegree() == -1 * dy / Math.abs(dy)) ||
                    (dy == 0 && d.getYDegree() == dy && d.getXDegree() == dx / Math.abs(dx))) {
                return d;
            }
        }

        throw new IllegalDirection("Rook이 이동할 수 없는 방향 입니다.");
    }
}
