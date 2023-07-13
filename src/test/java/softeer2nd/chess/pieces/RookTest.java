package softeer2nd.chess.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board;
import softeer2nd.chess.Direction;
import softeer2nd.chess.Position;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {

    private Board board;

    @BeforeEach
    void create_board() {
        board = new Board();
    }

    @Test
    @DisplayName("Rook이 동쪽으로 2칸 이동하는 것을 확인한다.")
    void verifyMovePositionToEast() {
        // given
        board.initializeEmpty();

        Piece sourceRook = Rook.createWhiteRook(new Position("d5"));
        Piece targetRook = Blank.createBlank(new Position("f5"));

        // when
        Direction direction = sourceRook.verifyMovePosition(targetRook);

        // then
        assertEquals(Direction.EAST, direction);
    }

    @Test
    @DisplayName("Rook이 서쪽으로 2칸 이동하는 것을 확인한다.")
    void verifyMovePositionToWest() {
        // given
        board.initializeEmpty();

        Piece sourceRook = Rook.createWhiteRook(new Position("d5"));
        Piece targetRook = Blank.createBlank(new Position("b5"));

        // when
        Direction direction = sourceRook.verifyMovePosition(targetRook);

        // then
        assertEquals(Direction.WEST, direction);
    }

    @Test
    @DisplayName("Rook이 북쪽으로 3칸 이동하는 것을 확인한다.")
    void verifyMovePositionToNorth() {
        // given
        board.initializeEmpty();

        Piece sourceRook = Rook.createWhiteRook(new Position("d5"));
        Piece targetRook = Blank.createBlank(new Position("d8"));

        // when
        Direction direction = sourceRook.verifyMovePosition(targetRook);

        // then
        assertEquals(Direction.NORTH, direction);
    }

    @Test
    @DisplayName("Rook이 남쪽으로 3칸 이동하는 것을 확인한다.")
    void verifyMovePositionToSouth() {
        // given
        board.initializeEmpty();

        Piece sourceRook = Rook.createWhiteRook(new Position("d5"));
        Piece targetRook = Blank.createBlank(new Position("d2"));

        // when
        Direction direction = sourceRook.verifyMovePosition(targetRook);

        // then
        assertEquals(Direction.SOUTH, direction);
    }
}