package softeer2nd.chess.exception;

public class IllegalDirection extends RuntimeException {
    public IllegalDirection() {
    }

    public IllegalDirection(String message) {
        super(message);
    }
}
