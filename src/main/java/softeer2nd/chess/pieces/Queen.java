package softeer2nd.chess.pieces;

import softeer2nd.chess.Position;

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
    public void verifyMovePosition() {

    }
}
