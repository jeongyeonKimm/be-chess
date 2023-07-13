package softeer2nd.chess.pieces;

import softeer2nd.chess.Direction;
import softeer2nd.chess.Position;
import softeer2nd.chess.exception.IllegalDirection;

import java.util.ArrayList;
import java.util.List;

import static softeer2nd.chess.pieces.Color.BLACK;
import static softeer2nd.chess.pieces.Color.WHITE;
import static softeer2nd.chess.pieces.Type.PAWN;

public class Pawn extends Piece{

    private boolean initialState = true;

    private Pawn(Color color, Type type, Position position) {
        super(color, type, position);
    }

    public static Piece createWhitePawn(Position position) {
        return new Pawn(WHITE, PAWN, position);
    }

    public static Piece createBlackPawn(Position position) {
        return new Pawn(BLACK, PAWN, position);
    }

    @Override
    public Direction verifyMovePosition(Piece target) {
        List<Direction> directions = isBlack() ? Direction.blackPawnDirection() : Direction.whitePawnDirection();
        return verifyDirection(directions, target.getPosition());
    }

    @Override
    public List<Position> getMovePath(Direction direction, Position target) {
        List<Position> movePath = new ArrayList<>();

        int dx = direction.getXDegree();
        int dy = direction.getYDegree();

        int maxMoveCount = Math.max(target.getY() - getPosition().getY(), target.getX() - getPosition().getX());

        for (int moveCount = 1; moveCount <= maxMoveCount; moveCount++) {
            int nx = this.getPosition().getX() + dx * moveCount;
            int ny = this.getPosition().getY() + dy * moveCount;
            Position position = new Position(nx, ny);
            if (position.equals(target)) {
                break;
            }
            movePath.add(position);
        }

        return movePath;
    }

    private Direction verifyDirection(List<Direction> directions, Position target) {
        int dx = target.getX() - getPosition().getX();
        int dy = target.getY() - getPosition().getY();

        for (Direction d : directions) {
            if (initialState) {
                if (dx == 0 && Math.abs(dy) > 0 && Math.abs(dy) <= 2 && d.getYDegree() == -1 * dy / Math.abs(dy)) {
                    this.initialState = false;
                    return d;
                }
            } else if (dx == d.getXDegree() && -1 * dy == d.getYDegree()) {
                return d;
            }
        }

        throw new IllegalDirection("Pawn이 이동할 수 없는 방향 입니다.");
    }
}
