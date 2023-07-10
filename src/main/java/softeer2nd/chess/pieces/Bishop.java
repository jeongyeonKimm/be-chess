package softeer2nd.chess.pieces;

import softeer2nd.chess.ChessGame;
import softeer2nd.chess.Position;
import softeer2nd.chess.exception.InvalidTargetPosition;

import static softeer2nd.chess.pieces.Color.BLACK;
import static softeer2nd.chess.pieces.Color.WHITE;
import static softeer2nd.chess.pieces.Type.BISHOP;

public class Bishop extends Piece {

    public Bishop(Color color, Type type, Position position) {
        super(color, type, position);
    }

    public static Piece createWhiteBishop(Position position) {
        return new Bishop(WHITE, BISHOP, position);
    }

    public static Piece createBlackBishop(Position position) {
        return new Bishop(BLACK, BISHOP, position);
    }

    @Override
    public void verifyMovePosition(Piece target, ChessGame chessGame) {
        Position sourcePos = this.getPosition();
        Position targetPos = target.getPosition();

        int dx = Integer.compare((targetPos.getX() - sourcePos.getX()), 0);
        int dy = Integer.compare((targetPos.getY() - sourcePos.getY()), 0);

        if (dx == 0 && dy == 0) {
            return;
        } else if (dx == 0 || dy == 0) {
            throw new InvalidTargetPosition("유효하지 않은 도착지 입니다.");
        }

        int nx = sourcePos.getX() + dx;
        int ny = sourcePos.getY() + dy;

        Position newPosition = new Position(nx, ny);

        verifyChessBoardBound(newPosition);
        verifySameTeamOnPath(chessGame.findPiece(newPosition.positionToString()));
        this.setNewPosition(newPosition);

        verifyMovePosition(target, chessGame);
    }
}
