package softeer2nd.chess.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board;
import softeer2nd.chess.Direction;
import softeer2nd.chess.Position;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    private Board board;

    @BeforeEach
    void create_board() {
        board = new Board();
    }

    @Test
    @DisplayName("Knight가 북동쪽으로 이동하는 것을 확인한다.")
    void verifyMovePositionToNorthEast() {
        // given
        board.initialize();

        Piece sourceKnight = Knight.createWhiteKnight(new Position("d4"));
        Piece targetKnight = Blank.createBlank(new Position("e6"));

        // when
        Direction direction = sourceKnight.verifyMovePosition(targetKnight);

        // then
        assertEquals(Direction.NNE, direction);
    }

    @Test
    @DisplayName("Knight가 북서쪽으로 이동하는 것을 확인한다.")
    void verifyMovePositionToNorthWest() {
        // given
        board.initializeEmpty();

        Piece sourceKnight = Knight.createWhiteKnight(new Position("d4"));
        Piece targetKnight = Blank.createBlank(new Position("c6"));

        // when
        Direction direction = sourceKnight.verifyMovePosition(targetKnight);

        // then
        assertEquals(Direction.NNW, direction);
    }

    @Test
    @DisplayName("Knight가 남동쪽으로 이동하는 것을 확인한다.")
    void verifyMovePositionToEastSouth() {
        // given
        board.initializeEmpty();

        Piece sourceKnight = Knight.createWhiteKnight(new Position("d4"));
        Piece targetKnight = Blank.createBlank(new Position("e2"));

        // when
        Direction direction = sourceKnight.verifyMovePosition(targetKnight);

        // then
        assertEquals(Direction.SSE, direction);
    }

    @Test
    @DisplayName("Knight가 남서쪽으로 이동하는 것을 확인한다.")
    void verifyMovePositionToSouthWest() {
        // given
        board.initializeEmpty();

        Piece sourceKnight = Knight.createWhiteKnight(new Position("d4"));
        Piece targetKnight = Blank.createBlank(new Position("c2"));

        // when
        Direction direction = sourceKnight.verifyMovePosition(targetKnight);

        // then
        assertEquals(Direction.SSW, direction);
    }

    @Test
    @DisplayName("Knight가 동북쪽으로 이동하는 것을 확인한다.")
    void verifyMovePositionToEastNorth() {
        // given
        board.initialize();

        Piece sourceKnight = Knight.createWhiteKnight(new Position("d4"));
        Piece targetKnight = Blank.createBlank(new Position("f5"));

        // when
        Direction direction = sourceKnight.verifyMovePosition(targetKnight);

        // then
        assertEquals(Direction.EEN, direction);
    }

    @Test
    @DisplayName("Knight가 서북쪽으로 이동하는 것을 확인한다.")
    void verifyMovePositionToWestNorth() {
        // given
        board.initializeEmpty();

        Piece sourceKnight = Knight.createWhiteKnight(new Position("d4"));
        Piece targetKnight = Blank.createBlank(new Position("b5"));

        // when
        Direction direction = sourceKnight.verifyMovePosition(targetKnight);

        // then
        assertEquals(Direction.WWN, direction);
    }

    @Test
    @DisplayName("Knight가 동남쪽으로 이동하는 것을 확인한다.")
    void verifyMovePositionToSouthEastSouth() {
        // given
        board.initializeEmpty();

        Piece sourceKnight = Knight.createWhiteKnight(new Position("d4"));
        Piece targetKnight = Blank.createBlank(new Position("f3"));

        // when
        Direction direction = sourceKnight.verifyMovePosition(targetKnight);

        // then
        assertEquals(Direction.EES, direction);
    }

    @Test
    @DisplayName("Knight가 서남쪽으로 이동하는 것을 확인한다.")
    void verifyMovePositionToWestSouth() {
        // given
        board.initializeEmpty();

        Piece sourceKnight = Knight.createWhiteKnight(new Position("d4"));
        Piece targetKnight = Blank.createBlank(new Position("b3"));

        // when
        Direction direction = sourceKnight.verifyMovePosition(targetKnight);

        // then
        assertEquals(Direction.WWS, direction);
    }
}