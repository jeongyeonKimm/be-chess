package softeer2nd.chess.exception;

public class InvalidTargetPosition extends RuntimeException {

    public InvalidTargetPosition() {
    }

    public InvalidTargetPosition(String message) {
        super(message);
    }
}
