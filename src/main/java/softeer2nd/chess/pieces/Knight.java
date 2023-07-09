package softeer2nd.chess.pieces;

import softeer2nd.chess.Position;

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
    public void verifyMovePosition() {

    }
}
