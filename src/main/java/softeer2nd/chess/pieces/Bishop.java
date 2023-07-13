package softeer2nd.chess.pieces;

import softeer2nd.chess.Direction;
import softeer2nd.chess.Position;
import softeer2nd.chess.exception.IllegalDirection;

import java.util.List;

import static softeer2nd.chess.pieces.Color.BLACK;
import static softeer2nd.chess.pieces.Color.WHITE;
import static softeer2nd.chess.pieces.Type.BISHOP;

public class Bishop extends Piece {

    private Bishop(Color color, Type type, Position position) {
        super(color, type, position);
    }

    public static Piece createWhiteBishop(Position position) {
        return new Bishop(WHITE, BISHOP, position);
    }

    public static Piece createBlackBishop(Position position) {
        return new Bishop(BLACK, BISHOP, position);
    }

    @Override
    public Direction verifyMovePosition(Piece target) {
        List<Direction> directions = Direction.diagonalDirection();
        return verifyDirection(directions, target.getPosition());
    }

    @Override
    public Direction verifyDirection(List<Direction> directions, Position target) {
        int dx = calculateDeltaX(target);
        int dy = calculateDeltaY(target);

        for (Direction d : directions) {
            if (d.isDiagonal(dx, dy)) {
                return d;
            }
        }

        throw new IllegalDirection("Bishop이 이동할 수 없는 방향 입니다.");
    }
}
