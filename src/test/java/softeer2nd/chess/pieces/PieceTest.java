package softeer2nd.chess.pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(Piece.Color.WHITE, Piece.Type.PAWN.getRepresentation());
        verifyPawn(Piece.Color.BLACK, Character.toUpperCase(Piece.Type.PAWN.getRepresentation()));
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

    @Test
    public void create_piece() {
        // pawn
        verifyPiece(Piece.createWhitePawn(), Piece.Color.WHITE, Piece.Type.PAWN.getRepresentation());
        verifyPiece(Piece.createBlackPawn(), Piece.Color.BLACK, Character.toUpperCase(Piece.Type.PAWN.getRepresentation()));

        // knight
        verifyPiece(Piece.createWhiteKnight(), Piece.Color.WHITE, Piece.Type.KNIGHT.getRepresentation());
        verifyPiece(Piece.createBlackKnight(), Piece.Color.BLACK, Character.toUpperCase(Piece.Type.KNIGHT.getRepresentation()));

        // rook
        verifyPiece(Piece.createWhiteRook(), Piece.Color.WHITE, Piece.Type.ROOK.getRepresentation());
        verifyPiece(Piece.createBlackRook(), Piece.Color.BLACK, Character.toUpperCase(Piece.Type.ROOK.getRepresentation()));

        // bishop
        verifyPiece(Piece.createWhiteBishop(), Piece.Color.WHITE, Piece.Type.BISHOP.getRepresentation());
        verifyPiece(Piece.createBlackBishop(), Piece.Color.BLACK, Character.toUpperCase(Piece.Type.BISHOP.getRepresentation()));

        // queen
        verifyPiece(Piece.createWhiteQueen(), Piece.Color.WHITE, Piece.Type.QUEEN.getRepresentation());
        verifyPiece(Piece.createBlackQueen(), Piece.Color.BLACK, Character.toUpperCase(Piece.Type.QUEEN.getRepresentation()));

        // king
        verifyPiece(Piece.createWhiteKing(), Piece.Color.WHITE, Piece.Type.KING.getRepresentation());
        verifyPiece(Piece.createBlackKing(), Piece.Color.BLACK, Character.toUpperCase(Piece.Type.KING.getRepresentation()));
    }

    @Test
    @DisplayName("기물이 흰색인지 검정색인지 확인한다.")
    public void verifyWhiteOrBlack() {
        Piece whitePawn = Piece.createPiece(Piece.Color.WHITE, Piece.Type.PAWN);
        assertTrue(whitePawn.isWhite());
        assertFalse(whitePawn.isBlack());

        Piece blackPawn = Piece.createPiece(Piece.Color.BLACK, Piece.Type.PAWN);
        assertFalse(blackPawn.isWhite());
        assertTrue(blackPawn.isBlack());
    }

    private void verifyPiece(final Piece piece, final Piece.Color color, final char representation) {
        assertEquals(color, piece.getColor());

        if (color.equals(Piece.Color.WHITE)) {
            assertEquals(representation, piece.getType().getRepresentation());
        } else {
            Character.toUpperCase(piece.getType().getRepresentation());
        }
    }

}