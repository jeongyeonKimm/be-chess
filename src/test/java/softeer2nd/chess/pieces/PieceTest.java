package softeer2nd.chess.pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.Piece.Type.*;

public class PieceTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(Piece.Color.WHITE, PAWN.getRepresentation());
        verifyPawn(Piece.Color.BLACK, Character.toUpperCase(PAWN.getRepresentation()));
    }

    @Test
    @DisplayName("색과 종류에 따라 다른 기물이 생성되는지 확인한다.")
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.createBlackPawn(), PAWN);
        verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), KNIGHT);
        verifyPiece(Piece.createWhiteRook(), Piece.createBlackRook(), ROOK);
        verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), BISHOP);
        verifyPiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), QUEEN);
        verifyPiece(Piece.createWhiteKing(), Piece.createBlackKing(), KING);

        Piece blank = Piece.createBlank();
        assertFalse(blank.isWhite());
        assertFalse(blank.isBlack());
        assertEquals(NO_PIECE, blank.getType());
    }

    @Test
    @DisplayName("기물이 흰색인지 검정색인지 확인한다.")
    public void verifyWhiteOrBlack() {
        Piece whitePawn = Piece.createPiece(Piece.Color.WHITE, PAWN);
        assertTrue(whitePawn.isWhite());
        assertFalse(whitePawn.isBlack());

        Piece blackPawn = Piece.createPiece(Piece.Color.BLACK, PAWN);
        assertFalse(blackPawn.isWhite());
        assertTrue(blackPawn.isBlack());
    }

    private void verifyPiece(final Piece white, final Piece black, final Piece.Type type) {
        assertEquals(white.getType().getRepresentation(), white.getType().getRepresentation());
    }

    private void verifyPawn(final Piece.Color color, final char representation) {
        Piece pawn;
        if (color.equals(Piece.Color.WHITE)) {
            pawn = Piece.createWhitePawn();
            assertThat(pawn.getType().getRepresentation()).isEqualTo(representation);
        } else {
            pawn = Piece.createBlackPawn();
            assertThat(Character.toUpperCase(pawn.getType().getRepresentation())).isEqualTo(representation);
        }

        assertThat(pawn.getColor()).isEqualTo(color);
    }
}