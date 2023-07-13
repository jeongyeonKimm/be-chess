package softeer2nd.chess.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board;
import softeer2nd.chess.Direction;
import softeer2nd.chess.Position;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {
    private Board board;

    @BeforeEach
    void create_board() {
        board = new Board();
    }

    @Test
    @DisplayName("Bishop이 북동쪽으로 2칸 이동하는 것을 확인한다.")
    void verifyMovePositionToNorthEast() {
        // given
        board.initializeEmpty();

        Piece sourceBishop = Bishop.createBlackBishop(new Position("d5"));
        Piece targetBishop = Blank.createBlank(new Position("g8"));

        // when
        Direction direction = sourceBishop.verifyMovePosition(targetBishop);

        // then
        assertEquals(Direction.NORTHEAST, direction);
    }

    @Test
    @DisplayName("Bishop이 북서쪽으로 2칸 이동하는 것을 확인한다.")
    void verifyMovePositionToNorthWest() {
        // given
        board.initializeEmpty();

        Piece sourceBishop = Bishop.createBlackBishop(new Position("d5"));
        Piece targetBishop = Blank.createBlank(new Position("b7"));

        // when
        Direction direction = sourceBishop.verifyMovePosition(targetBishop);

        // then
        assertEquals(Direction.NORTHWEST, direction);
    }

    @Test
    @DisplayName("Bishop이 남동쪽으로 3칸 이동하는 것을 확인한다.")
    void verifyMovePositionToSouthEast() {
        // given
        board.initializeEmpty();

        Piece sourceBishop = Bishop.createBlackBishop(new Position("d5"));
        Piece targetBishop = Blank.createBlank(new Position("g2"));

        // when
        Direction direction = sourceBishop.verifyMovePosition(targetBishop);

        // then
        assertEquals(Direction.SOUTHEAST, direction);
    }

    @Test
    @DisplayName("Bishop이 남서쪽으로 3칸 이동하는 것을 확인한다.")
    void verifyMovePositionToSouthWest() {
        // given
        board.initializeEmpty();

        Piece sourceBishop = Bishop.createBlackBishop(new Position("d5"));
        Piece targetBishop = Blank.createBlank(new Position("a2"));

        // when
        Direction direction = sourceBishop.verifyMovePosition(targetBishop);

        // then
        assertEquals(Direction.SOUTHWEST, direction);
    }
}