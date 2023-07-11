package softeer2nd.chess.pieces;

import softeer2nd.chess.ChessGame;
import softeer2nd.chess.Position;
import softeer2nd.chess.exception.InvalidTargetPosition;

import static softeer2nd.chess.pieces.Color.BLACK;
import static softeer2nd.chess.pieces.Color.WHITE;
import static softeer2nd.chess.pieces.Type.KING;

public class King extends Piece {

    public King(Color color, Type type, Position position) {
        super(color, type, position);
    }

    public static Piece createWhiteKing(Position position) {
        return new King(WHITE, KING, position);
    }

    public static Piece createBlackKing(Position position) {
        return new King(BLACK, KING, position);
    }

    @Override
    public void verifyMovePosition(Piece target, ChessGame chessGame) {
        Position sourcePos = this.getPosition();
        Position targetPos = target.getPosition();

        int dx = targetPos.getX() - sourcePos.getX();
        int dy = targetPos.getY() - sourcePos.getY();

        if (!(Math.abs(dx) == 1 && Math.abs(dy) == 1) &&
                !(Math.abs(dx) == 1 && Math.abs(dy) == 0) &&
                !(Math.abs(dx) == 0 && Math.abs(dy) == 1)) {
            throw new InvalidTargetPosition("유효하지 않은 도착지 입니다.");
        }

        int nx = sourcePos.getX() + dx;
        int ny = sourcePos.getY() + dy;

        Position newPosition = new Position(nx, ny);
        verifySameTeamOnPath(target);
        this.setNewPosition(newPosition);
    }
}
