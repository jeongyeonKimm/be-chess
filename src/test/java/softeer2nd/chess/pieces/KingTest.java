package softeer2nd.chess.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board;
import softeer2nd.chess.Direction;
import softeer2nd.chess.Position;

import static org.junit.jupiter.api.Assertions.*;

class KingTest {

    private Board board;

    @BeforeEach
    void create_board() {
        board = new Board();
    }

    @Test
    @DisplayName("King이 북동쪽으로 이동하는 것을 확인한다.")
    void verifyMovePositionToNorthEast() {
        // given
        board.initializeEmpty();

        Piece sourceKing = King.createBlackKing(new Position("f5"));
        Piece targetKing = Blank.createBlank(new Position("g6"));

        // when
        Direction direction = sourceKing.verifyMovePosition(targetKing);

        // then
        assertEquals(Direction.NORTHEAST, direction);
    }

    @Test
    @DisplayName("King이 북쪽으로 이동하는 것을 확인한다.")
    void verifyMovePositionToNorth() {
        // given
        board.initializeEmpty();

        Piece sourceKing = King.createBlackKing(new Position("f5"));
        Piece targetKing = Blank.createBlank(new Position("f6"));

        // when
        Direction direction = sourceKing.verifyMovePosition(targetKing);

        // then
        assertEquals(Direction.NORTH, direction);
    }

    @Test
    @DisplayName("King이 북서쪽으로 이동하는 것을 확인한다.")
    void verifyMovePositionToNorthWest() {
        // given
        board.initializeEmpty();

        Piece sourceKing = King.createBlackKing(new Position("f5"));
        Piece targetKing = Blank.createBlank(new Position("e6"));

        // when
        Direction direction = sourceKing.verifyMovePosition(targetKing);

        // then
        assertEquals(Direction.NORTHWEST, direction);
    }

    @Test
    @DisplayName("King이 서쪽으로 이동하는 것을 확인한다.")
    void verifyMovePositionToWest() {
        // given
        board.initializeEmpty();

        Piece sourceKing = King.createBlackKing(new Position("f5"));
        Piece targetKing = Blank.createBlank(new Position("e5"));

        // when
        Direction direction = sourceKing.verifyMovePosition(targetKing);

        // then
        assertEquals(Direction.WEST, direction);
    }

    @Test
    @DisplayName("King이 남서쪽으로 이동하는 것을 확인한다.")
    void verifyMovePositionToSouthWest() {
        // given
        board.initializeEmpty();

        Piece sourceKing = King.createBlackKing(new Position("f5"));
        Piece targetKing = Blank.createBlank(new Position("e4"));

        // when
        Direction direction = sourceKing.verifyMovePosition(targetKing);

        // then
        assertEquals(Direction.SOUTHWEST, direction);
    }

    @Test
    @DisplayName("King이 남쪽으로 이동하는 것을 확인한다.")
    void verifyMovePositionToSouth() {
        // given
        board.initializeEmpty();

        Piece sourceKing = King.createBlackKing(new Position("f5"));
        Piece targetKing = Blank.createBlank(new Position("f4"));

        // when
        Direction direction =  sourceKing.verifyMovePosition(targetKing);

        // then
        assertEquals(Direction.SOUTH, direction);
    }

    @Test
    @DisplayName("King이 남동쪽으로 이동하는 것을 확인한다.")
    void verifyMovePositionToSouthEast() {
        // given
        board.initializeEmpty();

        Piece sourceKing = King.createBlackKing(new Position("f5"));
        Piece targetKing = Blank.createBlank(new Position("g4"));

        // when
        Direction direction = sourceKing.verifyMovePosition(targetKing);

        // then
        assertEquals(Direction.SOUTHEAST, direction);
    }

    @Test
    @DisplayName("King이 동쪽으로 이동하는 것을 확인한다.")
    void verifyMovePositionToEast() {
        // given
        board.initializeEmpty();

        Piece sourceKing = King.createBlackKing(new Position("f5"));
        Piece targetKing = Blank.createBlank(new Position("g5"));

        // when
        Direction direction = sourceKing.verifyMovePosition(targetKing);

        // then
        assertEquals(Direction.EAST, direction);
    }
}