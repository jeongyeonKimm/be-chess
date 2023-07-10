package softeer2nd.chess.pieces;

import softeer2nd.chess.ChessGame;
import softeer2nd.chess.Position;

import static softeer2nd.chess.pieces.Color.NO_COLOR;
import static softeer2nd.chess.pieces.Type.NO_PIECE;

public class Blank extends Piece {

    public Blank(Color color, Type type, Position position) {
        super(color, type, position);
    }

    public static Piece createBlank(Position position) {
        return new Blank(NO_COLOR, NO_PIECE, position);
    }

    @Override
    public void verifyMovePosition(Piece target, ChessGame chessGame) {

    }
}
