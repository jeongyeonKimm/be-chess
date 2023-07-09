package softeer2nd.chess.pieces;

import softeer2nd.chess.Position;

import static softeer2nd.chess.pieces.Color.BLACK;
import static softeer2nd.chess.pieces.Color.WHITE;
import static softeer2nd.chess.pieces.Type.KING;

public class King extends Piece {

    public King(Color color, Type type, Position position) {
        super(color, type, position);
    }

    @Override
    public void verifyMovePosition() {

    }

    public static Piece createWhiteKing(Position position) {
        return new King(WHITE, KING, position);
    }

    public static Piece createBlackKing(Position position) {
        return new King(BLACK, KING, position);
    }
}
