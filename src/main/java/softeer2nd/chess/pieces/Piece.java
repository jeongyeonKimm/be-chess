package softeer2nd.chess.pieces;

import softeer2nd.chess.Position;
import softeer2nd.chess.exception.BoardOutOfBounds;
import softeer2nd.chess.exception.ExistSameColorPiece;

import java.util.Objects;

import static softeer2nd.chess.pieces.Color.*;

abstract public class Piece {

    private final Color color;
    private final Type type;
    private Position position;

    public Piece(Color color, Type type, Position position) {
        this.color = color;
        this.type = type;
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isWhite() {
        return color.equals(WHITE);
    }

    public boolean isBlack() {
        return Objects.equals(color, BLACK);
    }

    abstract public void verifyMovePosition(Piece target);

    public Piece createPiece(Color color, Type type, Position position) {
        if (color.equals(NO_COLOR)) {
            return Blank.createBlank(position);
        }

        boolean flag = isWhite();

        switch(type) {
            case PAWN:
                return flag ? Pawn.createWhitePawn(position) : Pawn.createBlackPawn(position);
            case KNIGHT:
                return flag ? Knight.createWhiteKnight(position) : Knight.createBlackKnight(position);
            case ROOK:
                return flag ? Rook.createWhiteRook(position) : Rook.createBlackRook(position);
            case BISHOP:
                return flag ? Bishop.createWhiteBishop(position) : Bishop.createBlackBishop(position);
            case QUEEN:
                return flag ? Queen.createWhiteQueen(position) : Queen.createBlackQueen(position);
            case KING:
                return flag ? King.createWhiteKing(position) : King.createBlackKing(position);
            default:
                return Blank.createBlank(position);
        }
    }

    public void move(Piece targetPiece) {
        Position targetPosition = targetPiece.getPosition();

        verifyChessBoardBound(targetPosition);
        verifySameTeamOnPath(targetPiece);
        verifyMovePosition(target);
    }

    private void verifyChessBoardBound(Position targetPosition) {
        if (Math.abs(position.getX() - targetPosition.getX()) > 1 ||
                Math.abs(position.getY() - targetPosition.getY()) > 1) {
            throw new BoardOutOfBounds("체스판 밖으로 이동할 수 없습니다.");
        }
    }

    private void verifySameTeamOnPath(Piece target) {
        if (this.color == target.getColor()) {
            throw new ExistSameColorPiece("이동하려는 위치에 같은 편의 기물이 있습니다.");
        }
    }
}