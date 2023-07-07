package softeer2nd.chess.exception;

public class ExistSameColorPiece extends RuntimeException {

    ExistSameColorPiece() {
    }

    public ExistSameColorPiece(String message) {
        super(message);
    }
}
