package softeer2nd.chess.exception;

public class ChessGameException extends RuntimeException {

    public ChessGameException() {
    }

    public ChessGameException(String message) {
        super(message);
    }
}
