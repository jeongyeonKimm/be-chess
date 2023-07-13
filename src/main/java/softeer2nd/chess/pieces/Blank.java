package softeer2nd.chess.pieces;

import softeer2nd.chess.Direction;
import softeer2nd.chess.Position;

import java.util.List;

import static softeer2nd.chess.pieces.Color.NO_COLOR;
import static softeer2nd.chess.pieces.Type.NO_PIECE;

public class Blank extends Piece {

    private Blank(Color color, Type type, Position position) {
        super(color, type, position);
    }

    public static Piece createBlank(Position position) {
        return new Blank(NO_COLOR, NO_PIECE, position);
    }

    @Override
    public Direction verifyMovePosition(Piece target) {
        return null;
    }

    @Override
    public Direction verifyDirection(List<Direction> directions, Position target) {
        return null;
    }
}
