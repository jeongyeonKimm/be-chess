package softeer2nd.chess.pieces;

import softeer2nd.chess.Direction;
import softeer2nd.chess.Position;
import softeer2nd.chess.exception.IllegalDirection;

import java.util.List;

import static softeer2nd.chess.pieces.Color.BLACK;
import static softeer2nd.chess.pieces.Color.WHITE;
import static softeer2nd.chess.pieces.Type.QUEEN;

public class Queen extends Piece {

    private Queen(Color color, Type type, Position position) {
        super(color, type, position);
    }

    public static Piece createWhiteQueen(Position position) {
        return new Queen(WHITE, QUEEN, position);
    }

    public static Piece createBlackQueen(Position position) {
        return new Queen(BLACK, QUEEN, position);
    }

    @Override
    public Direction verifyMovePosition(Piece target) {
        List<Direction> directions = Direction.everyDirection();

        return verifyDirection(directions, target.getPosition());
    }

    @Override
    public Direction verifyDirection(List<Direction> directions, Position target) {
        int dx = target.getX() - getPosition().getX();
        int dy = target.getY() - getPosition().getY();

        for (Direction d : directions) {
            if (d.isDiagonal(dx, dy) || d.isLinear(dx, dy)) {
                return d;
            }
        }

        throw new IllegalDirection("Queen이 이동할 수 없는 방향 입니다.");
    }
}
