package softeer2nd.chess.exception;

public class SameColorPiece extends RuntimeException {

    SameColorPiece() {
    }

    public SameColorPiece(String message) {
        super(message);
    }
}
