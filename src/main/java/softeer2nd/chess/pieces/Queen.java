package softeer2nd.chess.pieces;

import softeer2nd.chess.ChessGame;
import softeer2nd.chess.Position;
import softeer2nd.chess.exception.InvalidTargetPosition;

import static softeer2nd.chess.pieces.Color.BLACK;
import static softeer2nd.chess.pieces.Color.WHITE;
import static softeer2nd.chess.pieces.Type.QUEEN;

public class Queen extends Piece {

    public Queen(Color color, Type type, Position position) {
        super(color, type, position);
    }

    public static Piece createWhiteQueen(Position position) {
        return new Queen(WHITE, QUEEN, position);
    }

    public static Piece createBlackQueen(Position position) {
        return new Queen(BLACK, QUEEN, position);
    }

    @Override
    public void verifyMovePosition(Piece target, ChessGame chessGame) {
        Position sourcePos = this.getPosition();
        Position targetPos = target.getPosition();

        // 전후좌우
        if (sourcePos.getX() == targetPos.getX() && sourcePos.getY() == targetPos.getY()) {
            return;
        }

        int dx = Integer.compare((targetPos.getX() - sourcePos.getX()), 0);
        int dy = Integer.compare((targetPos.getY() - sourcePos.getY()), 0);

        if (!verifySameLine(sourcePos, targetPos)) {
            throw new InvalidTargetPosition("유효하지 않은 도착지 입니다.");
        }

        int nx = sourcePos.getX() + dx;
        int ny = sourcePos.getY() + dy;

        Position newPosition = new Position(nx, ny);
        verifySameTeamOnPath(target);
        this.setNewPosition(newPosition);

        verifyMovePosition(target, chessGame);
    }

    private boolean verifySameLine(Position source, Position target) {
        // 전후좌우
        if (target.getX() == source.getX() || target.getY() == source.getY()) {
            return true;
        }

        // 대각선
        if (Math.abs(target.getX() - source.getX()) == Math.abs(target.getY() - source.getY())) {
            return true;
        }

        return false;
    }
}
