package softeer2nd.chess.pieces;

import softeer2nd.chess.ChessGame;
import softeer2nd.chess.Position;

import static softeer2nd.chess.pieces.Color.BLACK;
import static softeer2nd.chess.pieces.Color.WHITE;
import static softeer2nd.chess.pieces.Type.BISHOP;

public class Bishop extends Piece {

    public Bishop(Color color, Type type, Position position) {
        super(color, type, position);
    }

    public static Piece createWhiteBishop(Position position) {
        return new Bishop(WHITE, BISHOP, position);
    }

    public static Piece createBlackBishop(Position position) {
        return new Bishop(BLACK, BISHOP, position);
    }

    @Override
    public void verifyMovePosition(Piece target, ChessGame chessGame) {

    }
}
