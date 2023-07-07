package softeer2nd.chess.exception;

public class BoardOutOfBounds extends RuntimeException {

    BoardOutOfBounds() {
    }

    public BoardOutOfBounds(String message) {
        super(message);
    }
}
