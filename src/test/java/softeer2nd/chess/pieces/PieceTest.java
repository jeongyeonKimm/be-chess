package softeer2nd.chess.pieces;

import org.junit.jupiter.api.*;
import softeer2nd.chess.Position;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.Type.*;

class PieceTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    void create() {
        verifyPawn(Color.WHITE, PAWN.getRepresentation());
        verifyPawn(Color.BLACK, Character.toUpperCase(PAWN.getRepresentation()));
    }

    @Test
    @DisplayName("색과 종류에 따라 다른 기물이 생성되는지 확인한다.")
    void create_piece() {
        verifyPiece(Pawn.createWhitePawn(new Position(6, 0)),
                Pawn.createBlackPawn(new Position(1, 0)), PAWN);
        verifyPiece(Knight.createWhiteKnight(new Position(7, 1)),
                Knight.createBlackKnight(new Position(0, 1)), KNIGHT);
        verifyPiece(Rook.createWhiteRook(new Position(7, 0)),
                Rook.createBlackRook(new Position(0, 0)), ROOK);
        verifyPiece(Bishop.createWhiteBishop(new Position(7, 2)),
                Bishop.createBlackBishop(new Position(0, 2)), BISHOP);
        verifyPiece(Queen.createWhiteQueen(new Position(7, 3)),
                Queen.createBlackQueen(new Position(0, 3)), QUEEN);
        verifyPiece(King.createWhiteKing(new Position(7, 4)),
                King.createBlackKing(new Position(0, 4)), KING);

        Piece blank = Blank.createBlank(new Position(2, 0));
        assertFalse(blank.isWhite());
        assertFalse(blank.isBlack());
        assertEquals(NO_PIECE, blank.getType());
    }

    @Test
    @DisplayName("기물이 흰색인지 검정색인지 확인한다.")
    void verifyWhiteOrBlack() {
        Piece whitePawn = Pawn.createWhitePawn(new Position(6, 0));
        assertTrue(whitePawn.isWhite());
        assertFalse(whitePawn.isBlack());

        Piece blackPawn = Pawn.createBlackPawn(new Position(1, 0));
        assertFalse(blackPawn.isWhite());
        assertTrue(blackPawn.isBlack());
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getType());

        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getType());
    }

    private void verifyPawn(final Color color, final char representation) {
        Piece pawn;
        if (color == Color.WHITE) {
            pawn = Pawn.createWhitePawn(new Position(6, 0));
            assertThat(pawn.getType().getRepresentation()).isEqualTo(representation);
        } else {
            pawn = Pawn.createBlackPawn(new Position(1, 0));
            assertThat(Character.toUpperCase(pawn.getType().getRepresentation())).isEqualTo(representation);
        }

        assertThat(pawn.getColor()).isEqualTo(color);
    }
}