package softeer2nd.chess.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board;
import softeer2nd.chess.ChessGame;
import softeer2nd.chess.Position;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {

    private Board board;

    @BeforeEach
    void create_board() {
        board = new Board();
    }

    @Test
    @DisplayName("Queen이 북동쪽으로 3칸 이동하는 것을 확인한다.")
    void verifyMovePositionToNorthEast() {
        // given
        board.initializeEmpty();

        Piece sourceQueen = Queen.createBlackQueen(new Position("d4"));
        Piece targetQueen = Blank.createBlank(new Position("g7"));

        // when
        sourceQueen.verifyMovePosition(targetQueen);

        // then
        assertEquals("g7", sourceQueen.getPosition().positionToString());
    }

    @Test
    @DisplayName("Queen이 동쪽으로 4칸 이동하는 것을 확인한다.")
    void verifyMovePositionToEast() {
        // given
        board.initializeEmpty();

        Piece sourceQueen = Queen.createBlackQueen(new Position("d4"));
        Piece targetQueen = Blank.createBlank(new Position("h4"));

        // when
        sourceQueen.verifyMovePosition(targetQueen);

        // then
        assertEquals("h4", sourceQueen.getPosition().positionToString());
    }

    @Test
    @DisplayName("Queen이 남동쪽으로 2칸 이동하는 것을 확인한다.")
    void verifyMovePositionToSouthEast() {
        // given
        board.initializeEmpty();

        Piece sourceQueen = Queen.createBlackQueen(new Position("d4"));
        Piece targetQueen = Blank.createBlank(new Position("f2"));

        // when
        sourceQueen.verifyMovePosition(targetQueen);

        // then
        assertEquals("f2", sourceQueen.getPosition().positionToString());
    }

    @Test
    @DisplayName("Queen이 남쪽으로 3칸 이동하는 것을 확인한다.")
    void verifyMovePositionToSouth() {
        // given
        board.initializeEmpty();

        Piece sourceQueen = Queen.createBlackQueen(new Position("d4"));
        Piece targetQueen = Blank.createBlank(new Position("d1"));

        // when
        sourceQueen.verifyMovePosition(targetQueen);

        // then
        assertEquals("d1", sourceQueen.getPosition().positionToString());
    }

    @Test
    @DisplayName("Queen이 남서쪽으로 2칸 이동하는 것을 확인한다.")
    void verifyMovePositionToSouthWest() {
        // given
        board.initializeEmpty();

        Piece sourceQueen = Queen.createBlackQueen(new Position("d4"));
        Piece targetQueen = Blank.createBlank(new Position("a1"));

        // when
        sourceQueen.verifyMovePosition(targetQueen);

        // then
        assertEquals("a1", sourceQueen.getPosition().positionToString());
    }

    @Test
    @DisplayName("Queen이 서쪽으로 1칸 이동하는 것을 확인한다.")
    void verifyMovePositionToWest() {
        // given
        board.initializeEmpty();

        Piece sourceQueen = Queen.createBlackQueen(new Position("d4"));
        Piece targetQueen = Blank.createBlank(new Position("c4"));

        // when
        sourceQueen.verifyMovePosition(targetQueen);

        // then
        assertEquals("c4", sourceQueen.getPosition().positionToString());
    }

    @Test
    @DisplayName("Queen이 북서쪽으로 2칸 이동하는 것을 확인한다.")
    void verifyMovePositionToNorthWest() {
        // given
        board.initializeEmpty();

        Piece sourceQueen = Queen.createBlackQueen(new Position("d4"));
        Piece targetQueen = Blank.createBlank(new Position("b6"));

        // when
        sourceQueen.verifyMovePosition(targetQueen);

        // then
        assertEquals("b6", sourceQueen.getPosition().positionToString());
    }

    @Test
    @DisplayName("Queen이 북쪽으로 4칸 이동하는 것을 확인한다.")
    void verifyMovePositionToNorth() {
        // given
        board.initializeEmpty();

        Piece sourceQueen = Queen.createBlackQueen(new Position("d4"));
        Piece targetQueen = Blank.createBlank(new Position("d8"));

        // when
        sourceQueen.verifyMovePosition(targetQueen);

        // then
        assertEquals("d8", sourceQueen.getPosition().positionToString());
    }
}