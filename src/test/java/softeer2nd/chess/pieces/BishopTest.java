package softeer2nd.chess.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board;
import softeer2nd.chess.ChessGame;
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

        Piece sourceBishop = Bishop.createBlackBishop(new Position("c3"));
        Piece targetBishop = Blank.createBlank(new Position("e5"));

        // when
        sourceBishop.verifyMovePosition(targetBishop);

        // then
        assertEquals("e5", sourceBishop.getPosition().positionToString());
    }

    @Test
    @DisplayName("Bishop이 북서쪽으로 2칸 이동하는 것을 확인한다.")
    void verifyMovePositionToNorthWest() {
        // given
        board.initializeEmpty();

        Piece sourceBishop = Bishop.createBlackBishop(new Position("f3"));
        Piece targetBishop = Blank.createBlank(new Position("d5"));

        // when
        sourceBishop.verifyMovePosition(targetBishop);

        // then
        assertEquals("d5", sourceBishop.getPosition().positionToString());
    }

    @Test
    @DisplayName("Bishop이 남동쪽으로 3칸 이동하는 것을 확인한다.")
    void verifyMovePositionToSouthEast() {
        // given
        board.initializeEmpty();

        Piece sourceBishop = Bishop.createBlackBishop(new Position("c6"));
        Piece targetBishop = Blank.createBlank(new Position("f3"));

        // when
        sourceBishop.verifyMovePosition(targetBishop);

        // then
        assertEquals("f3", sourceBishop.getPosition().positionToString());
    }

    @Test
    @DisplayName("Bishop이 남서쪽으로 3칸 이동하는 것을 확인한다.")
    void verifyMovePositionToSouthWest() {
        // given
        board.initializeEmpty();

        Piece sourceBishop = Bishop.createBlackBishop(new Position("f6"));
        Piece targetBishop = Blank.createBlank(new Position("c3"));

        // when
        sourceBishop.verifyMovePosition(targetBishop);

        // then
        assertEquals("c3", sourceBishop.getPosition().positionToString());
    }

}