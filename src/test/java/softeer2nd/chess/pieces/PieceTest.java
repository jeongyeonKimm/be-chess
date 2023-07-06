package softeer2nd.chess.pieces;

import org.junit.jupiter.api.*;
import softeer2nd.chess.Position;

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
        verifyPiece(Piece.createWhitePawn(new Position(6, 0)), Piece.createBlackPawn(new Position(1, 0)), PAWN);
        verifyPiece(Piece.createWhiteKnight(new Position(7, 1)), Piece.createBlackKnight(new Position(0, 1)), KNIGHT);
        verifyPiece(Piece.createWhiteRook(new Position(7, 0)), Piece.createBlackRook(new Position(0, 0)), ROOK);
        verifyPiece(Piece.createWhiteBishop(new Position(7, 2)), Piece.createBlackBishop(new Position(0, 2)), BISHOP);
        verifyPiece(Piece.createWhiteQueen(new Position(7, 3)), Piece.createBlackQueen(new Position(0, 3)), QUEEN);
        verifyPiece(Piece.createWhiteKing(new Position(7, 4)), Piece.createBlackKing(new Position(0, 4)), KING);

        Piece blank = Piece.createBlank(new Position(2, 0));
        assertFalse(blank.isWhite());
        assertFalse(blank.isBlack());
        assertEquals(NO_PIECE, blank.getType());
    }

    @Test
    @DisplayName("기물이 흰색인지 검정색인지 확인한다.")
    public void verifyWhiteOrBlack() {
        Piece whitePawn = Piece.createPiece(Piece.Color.WHITE, PAWN, new Position(6, 0));
        assertTrue(whitePawn.isWhite());
        assertFalse(whitePawn.isBlack());

        Piece blackPawn = Piece.createPiece(Piece.Color.BLACK, PAWN, new Position(1, 0));
        assertFalse(blackPawn.isWhite());
        assertTrue(blackPawn.isBlack());
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Piece.Type type) {
        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getType());

        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getType());
    }

    private void verifyPawn(final Piece.Color color, final char representation) {
        Piece pawn;
        if (color.equals(Piece.Color.WHITE)) {
            pawn = Piece.createWhitePawn(new Position(6, 0));
            assertThat(pawn.getType().getRepresentation()).isEqualTo(representation);
        } else {
            pawn = Piece.createBlackPawn(new Position(1, 0));
            assertThat(Character.toUpperCase(pawn.getType().getRepresentation())).isEqualTo(representation);
        }

        assertThat(pawn.getColor()).isEqualTo(color);
    }
}