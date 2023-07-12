package softeer2nd.chess.pieces;

import softeer2nd.chess.ChessGame;
import softeer2nd.chess.Position;
import softeer2nd.chess.exception.InvalidTargetPosition;

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
    public void verifyMovePosition(Piece target) {
        Position sourcePos = this.getPosition();
        Position targetPos = target.getPosition();

        int dx = targetPos.getX() - sourcePos.getX();
        int dy = targetPos.getY() - sourcePos.getY();

        if ((Math.abs(dx) != 1 || Math.abs(dy) != 2) &&
                (Math.abs(dx) != 2 || Math.abs(dy) != 1)) {
            throw new InvalidTargetPosition("유효하지 않은 도착지 입니다.");
        }

        int nx = sourcePos.getX() + dx;
        int ny = sourcePos.getY() + dy;

        Position newPosition = new Position(nx, ny);
        verifySameTeamOnPath(target);
        this.setNewPosition(newPosition);
    }
}
