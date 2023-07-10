package softeer2nd.chess.pieces;

import softeer2nd.chess.ChessGame;
import softeer2nd.chess.Position;

import static softeer2nd.chess.pieces.Color.BLACK;
import static softeer2nd.chess.pieces.Color.WHITE;
import static softeer2nd.chess.pieces.Type.PAWN;

public class Pawn extends Piece{

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

    }
}
