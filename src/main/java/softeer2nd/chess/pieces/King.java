package softeer2nd.chess.pieces;

import softeer2nd.chess.Direction;
import softeer2nd.chess.Position;
import softeer2nd.chess.exception.IllegalDirection;

import java.util.List;

import static softeer2nd.chess.pieces.Color.BLACK;
import static softeer2nd.chess.pieces.Color.WHITE;
import static softeer2nd.chess.pieces.Type.KING;

public class King extends Piece {

    private King(Color color, Type type, Position position) {
        super(color, type, position);
    }

    public static Piece createWhiteKing(Position position) {
        return new King(WHITE, KING, position);
    }

    public static Piece createBlackKing(Position position) {
        return new King(BLACK, KING, position);
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
            if (d.getXDegree() == dx && d.getYDegree() == -1 * dy) {
                return d;
            }
        }

        throw new IllegalDirection("King이 이동할 수 없는 방향 입니다.");
    }
}
