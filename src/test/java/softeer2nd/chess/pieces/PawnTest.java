package softeer2nd.chess.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board;
import softeer2nd.chess.Direction;
import softeer2nd.chess.Position;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    private Board board;

    @BeforeEach
    void create_board() {
        board = new Board();
    }

    @Test
    @DisplayName("초기 상태에 흰색 Pawn이 1칸 전진 가능한 것을 확인한다.")
    void verifyMovePositionInInitialStateWhite() {
        // given
        board.initializeEmpty();

        Piece sourcePawn = Pawn.createWhitePawn(new Position("b2"));
        Piece targetPawn = Blank.createBlank(new Position("b3"));

        // when
        Direction direction = sourcePawn.verifyMovePosition(targetPawn);

        // then
        assertEquals(Direction.NORTH, direction);
    }

    @Test
    @DisplayName("초기 상태에 흰색 Pawn이 2칸 전진 가능한 것을 확인한다.")
    void verifyMovePositionInInitialState2White() {
        // given
        board.initializeEmpty();

        Piece sourcePawn = Pawn.createWhitePawn(new Position("d2"));
        Piece targetPawn = Blank.createBlank(new Position("d4"));

        // when
        Direction direction = sourcePawn.verifyMovePosition(targetPawn);

        // then
        assertEquals(Direction.NORTH, direction);
    }

    @Test
    @DisplayName("초기 상태가 아닐 때 흰색 Pawn이 1칸 전진 가능한 것을 확인한다.")
    void verifyMovePositionWhite() {
        // given
        board.initializeEmpty();

        Piece sourcePawn = Pawn.createWhitePawn(new Position("d2"));
        Piece targetPawn = Blank.createBlank(new Position("d4"));

        sourcePawn.verifyMovePosition(targetPawn);
        sourcePawn.setNewPosition(targetPawn.getPosition());

        targetPawn = Blank.createBlank(new Position("d5"));

        // when
        Direction direction = sourcePawn.verifyMovePosition(targetPawn);

        // then
        assertEquals(Direction.NORTH, direction);
    }

    @Test
    @DisplayName("초기 상태에 검은색 Pawn이 1칸 전진 가능한 것을 확인한다.")
    void verifyMovePositionInInitialStateBlack() {
        // given
        board.initializeEmpty();

        Piece sourcePawn = Pawn.createBlackPawn(new Position("d7"));
        Piece targetPawn = Blank.createBlank(new Position("d6"));

        // when
        Direction direction = sourcePawn.verifyMovePosition(targetPawn);

        // then
        assertEquals(Direction.SOUTH, direction);
    }

    @Test
    @DisplayName("초기 상태에 검은색 Pawn이 2칸 전진 가능한 것을 확인한다.")
    void verifyMovePositionInInitialState2Black() {
        // given
        board.initializeEmpty();

        Piece sourcePawn = Pawn.createBlackPawn(new Position("d7"));
        Piece targetPawn = Blank.createBlank(new Position("d5"));

        // when
        Direction direction = sourcePawn.verifyMovePosition(targetPawn);

        // then
        assertEquals(Direction.SOUTH, direction);
    }

    @Test
    @DisplayName("초기 상태가 아닐 때 검은색 Pawn이 1칸 전진 가능한 것을 확인한다.")
    void verifyMovePositionBlack() {
        // given
        board.initializeEmpty();

        Piece sourcePawn = Pawn.createBlackPawn(new Position("d7"));
        Piece targetPawn = Blank.createBlank(new Position("d5"));

        sourcePawn.verifyMovePosition(targetPawn);
        sourcePawn.setNewPosition(targetPawn.getPosition());

        targetPawn = Blank.createBlank(new Position("d4"));

        // when
        Direction direction = sourcePawn.verifyMovePosition(targetPawn);

        // then
        assertEquals(Direction.SOUTH, direction);
    }
}