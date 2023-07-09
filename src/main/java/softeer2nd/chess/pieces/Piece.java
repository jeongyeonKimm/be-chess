package softeer2nd.chess.pieces;

import softeer2nd.chess.ChessGame;
import softeer2nd.chess.Position;
import softeer2nd.chess.exception.BoardOutOfBounds;
import softeer2nd.chess.exception.IllegalDirection;
import softeer2nd.chess.exception.ExistSameColorPiece;

import java.util.Objects;

import static softeer2nd.chess.pieces.Color.BLACK;
import static softeer2nd.chess.pieces.Color.WHITE;

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

    abstract public void verifyMovePosition();

    public void move(Piece targetPiece) {
        Position targetPosition = targetPiece.getPosition();

        verifyChessBoardBound(targetPosition);
        verifySameTeamOnPath(targetPiece);
        verifyMovePosition();
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