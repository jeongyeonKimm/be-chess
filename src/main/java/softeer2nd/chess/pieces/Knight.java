package softeer2nd.chess.pieces;

import softeer2nd.chess.Direction;
import softeer2nd.chess.Position;
import softeer2nd.chess.exception.IllegalDirection;

import java.util.ArrayList;
import java.util.List;

import static softeer2nd.chess.pieces.Color.BLACK;
import static softeer2nd.chess.pieces.Color.WHITE;
import static softeer2nd.chess.pieces.Type.KNIGHT;

public class Knight extends Piece {

    public Knight(Color color, Type type, Position position) {
        super(color, type, position);
    }

    public static Piece createWhiteKnight(Position position) {
        return new Knight(WHITE, KNIGHT, position);
    }

    public static Piece createBlackKnight(Position position) {
        return new Knight(BLACK, KNIGHT, position);
    }

    @Override
    public Direction verifyMovePosition(Piece target) {
        List<Direction> directions = Direction.knightDirection();
        return verifyDirection(directions, target.getPosition());
    }

    @Override
    public List<Position> getMovePath(Direction direction, Position target) {
        return new ArrayList<>();
    }

    private Direction verifyDirection(List<Direction> directions, Position target) {
        int dx = target.getX() - getPosition().getX();
        int dy = target.getY() - getPosition().getY();

        for (Direction d : directions) {
            if (dx == d.getXDegree() && -1 * dy == d.getYDegree()) {
                return d;
            }
        }

        throw new IllegalDirection("Knight가 이동할 수 없는 방향 입니다.");
    }
}
