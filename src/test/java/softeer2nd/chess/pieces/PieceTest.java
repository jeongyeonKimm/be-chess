package softeer2nd.chess.pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest {

    @Test
    public void create_기본생성자() throws Exception {
        Piece pawn = Piece.createPiece(Piece.WHITE_COLOR, "pawn");
        assertEquals(Piece.WHITE_COLOR, pawn.getColor());
        // assertEquals(Piece.WHITE_PAWN_REPRESENTATION, pawn.getRepresentation());
    }

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(Piece.WHITE_COLOR, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPawn(Piece.BLACK_COLOR, Piece.BLACK_PAWN_REPRESENTATION);
    }

    private void verifyPawn(final String color, final char representation) {
        Piece pawn;
        if (color.equals(Piece.WHITE_COLOR)) {
            pawn = Piece.createWhitePawn();
        } else {
            pawn = Piece.createBlackPawn();
        }
        assertThat(pawn.getColor()).isEqualTo(color);
        assertThat(pawn.getRepresentation()).isEqualTo(representation);
    }

    @Test
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.WHITE_COLOR, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPiece(Piece.createBlackPawn(), Piece.BLACK_COLOR, Piece.BLACK_PAWN_REPRESENTATION);

        // [...다른 Piece 구현...]
    }

    private void verifyPiece(final Piece piece, final String color, final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
    }

}