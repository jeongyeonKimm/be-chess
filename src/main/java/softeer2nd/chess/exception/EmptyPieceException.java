package softeer2nd.chess.exception;

public class EmptyPieceException extends RuntimeException {
    public EmptyPieceException() {
    }

    public EmptyPieceException(String message) {
        super(message);
    }
}
