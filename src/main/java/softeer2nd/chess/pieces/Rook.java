package softeer2nd.chess.pieces;

import softeer2nd.chess.ChessGame;
import softeer2nd.chess.Position;
import softeer2nd.chess.exception.InvalidTargetPosition;

import static softeer2nd.chess.pieces.Color.BLACK;
import static softeer2nd.chess.pieces.Color.WHITE;
import static softeer2nd.chess.pieces.Type.ROOK;

public class Rook extends Piece {

    public Rook(Color color, Type type, Position position) {
        super(color, type, position);
    }

    public static Piece createWhiteRook(Position position) {
        return new Rook(WHITE, ROOK, position);
    }

    public static Piece createBlackRook(Position position) {
        return new Rook(BLACK, ROOK, position);
    }

    @Override
    public void verifyMovePosition(Piece target, ChessGame chessGame) {
        Position sourcePos = this.getPosition();
        Position targetPos = target.getPosition();

        int dx = Integer.compare((targetPos.getX() - sourcePos.getX()), 0);
        int dy = Integer.compare((targetPos.getY() - sourcePos.getY()), 0);

        if (dx == 0 && dy == 0) {
            return;
        } else if ((dx == 1 && dy == 1) || (dx == -1 && dy == -1)) {
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
