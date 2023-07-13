package softeer2nd.chess.exception;

public class EmptyPieceException extends ChessGameException {
    public EmptyPieceException() {
    }

    public EmptyPieceException(String message) {
        super(message);
    }
}
