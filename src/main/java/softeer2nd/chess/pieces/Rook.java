package softeer2nd.chess.pieces;

import softeer2nd.chess.Position;

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
    public void verifyMovePosition(Piece target) {

    }
}
