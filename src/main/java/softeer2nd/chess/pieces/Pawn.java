package softeer2nd.chess.pieces;

import softeer2nd.chess.ChessGame;
import softeer2nd.chess.Position;
import softeer2nd.chess.exception.ExistSameColorPiece;
import softeer2nd.chess.exception.InvalidTargetPosition;

import static softeer2nd.chess.pieces.Color.BLACK;
import static softeer2nd.chess.pieces.Color.WHITE;
import static softeer2nd.chess.pieces.Type.PAWN;

public class Pawn extends Piece{

    private boolean initialState = true;

    public Pawn(Color color, Type type, Position position) {
        super(color, type, position);
    }

    public static Piece createWhitePawn(Position position) {
        return new Pawn(WHITE, PAWN, position);
    }

    public static Piece createBlackPawn(Position position) {
        return new Pawn(BLACK, PAWN, position);
    }

    @Override
    public void verifyMovePosition(Piece target, ChessGame chessGame) {
        Position sourcePos = this.getPosition();
        Position targetPos = target.getPosition();

        int dx = targetPos.getX() - sourcePos.getX();
        int dy = targetPos.getY() - sourcePos.getY();

        int nx = sourcePos.getX() + dx;
        int ny = sourcePos.getY() + dy;
        Position newPosition = new Position(nx, ny);

        if (!initialState) {
            if (dx == 0 && dy == -2) {
                throw new InvalidTargetPosition("유효하지 않은 도착지 입니다.");
            }
        } else if (verifyDiagonal(dx, dy)) {
            if (!verifyOtherTeamOnDiagonal(target)) {
                throw new ExistSameColorPiece("같은 편 기물 입니다.");
            }
        } else if (dx != 0 || dy != -1) {
            throw new InvalidTargetPosition("유효하지 않은 도착지 입니다.");
        }

        verifyChessBoardBound(newPosition);
        verifySameTeamOnPath(chessGame.findPiece(newPosition.positionToString()));
        this.setNewPosition(newPosition);
    }

    private boolean verifyDiagonal(int dx, int dy) {
        return dy == -1 && Math.abs(dx) == 1;
    }

    private boolean verifyOtherTeamOnDiagonal(Piece target) {
        return target.getColor() != this.getColor();
    }
}
