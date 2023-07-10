package softeer2nd.chess.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board;
import softeer2nd.chess.ChessGame;
import softeer2nd.chess.Position;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    private Board board;
    private ChessGame chessGame;

    @BeforeEach
    void create_board() {
        board = new Board();
        chessGame = new ChessGame(board);
    }

    @Test
    @DisplayName("Knight가 북동쪽으로 이동하는 것을 확인한다.")
    void verifyMovePositionToNorthEast() {
        // given
        board.initialize();

        Piece sourceKnight = Knight.createWhiteKnight(new Position("b3"));
        Piece targetKnight = Knight.createWhiteKnight(new Position("c5"));

        // when
        sourceKnight.verifyMovePosition(targetKnight, chessGame);

        // then
        assertEquals("c5", sourceKnight.getPosition().positionToString());
    }

    @Test
    @DisplayName("Knight가 북서쪽으로 이동하는 것을 확인한다.")
    void verifyMovePositionToNorthWest() {
        // given
        board.initializeEmpty();

        Piece sourceKnight = Knight.createWhiteKnight(new Position("g3"));
        Piece targetKnight = Knight.createWhiteKnight(new Position("f5"));

        // when
        sourceKnight.verifyMovePosition(targetKnight, chessGame);

        // then
        assertEquals("f5", sourceKnight.getPosition().positionToString());
    }

    @Test
    @DisplayName("Knight가 남동쪽으로 이동하는 것을 확인한다.")
    void verifyMovePositionToEastSouth() {
        // given
        board.initializeEmpty();

        Piece sourceKnight = Knight.createWhiteKnight(new Position("b6"));
        Piece targetKnight = Knight.createWhiteKnight(new Position("c4"));

        // when
        sourceKnight.verifyMovePosition(targetKnight, chessGame);

        // then
        assertEquals("c4", sourceKnight.getPosition().positionToString());
    }

    @Test
    @DisplayName("Knight가 남서쪽으로 이동하는 것을 확인한다.")
    void verifyMovePositionToSouthWest() {
        // given
        board.initializeEmpty();

        Piece sourceKnight = Knight.createWhiteKnight(new Position("g6"));
        Piece targetKnight = Knight.createWhiteKnight(new Position("f4"));

        // when
        sourceKnight.verifyMovePosition(targetKnight, chessGame);

        // then
        assertEquals("f4", sourceKnight.getPosition().positionToString());
    }

    @Test
    @DisplayName("Knight가 동북쪽으로 이동하는 것을 확인한다.")
    void verifyMovePositionToEastNorth() {
        // given
        board.initialize();

        Piece sourceKnight = Knight.createWhiteKnight(new Position("b3"));
        Piece targetKnight = Knight.createWhiteKnight(new Position("d4"));

        // when
        sourceKnight.verifyMovePosition(targetKnight, chessGame);

        // then
        assertEquals("d4", sourceKnight.getPosition().positionToString());
    }

    @Test
    @DisplayName("Knight가 서북쪽으로 이동하는 것을 확인한다.")
    void verifyMovePositionToWestNorth() {
        // given
        board.initializeEmpty();

        Piece sourceKnight = Knight.createWhiteKnight(new Position("g3"));
        Piece targetKnight = Knight.createWhiteKnight(new Position("e4"));

        // when
        sourceKnight.verifyMovePosition(targetKnight, chessGame);

        // then
        assertEquals("e4", sourceKnight.getPosition().positionToString());
    }

    @Test
    @DisplayName("Knight가 동남쪽으로 이동하는 것을 확인한다.")
    void verifyMovePositionToSouthEastSouth() {
        // given
        board.initializeEmpty();

        Piece sourceKnight = Knight.createWhiteKnight(new Position("b4"));
        Piece targetKnight = Knight.createWhiteKnight(new Position("d3"));

        // when
        sourceKnight.verifyMovePosition(targetKnight, chessGame);

        // then
        assertEquals("d3", sourceKnight.getPosition().positionToString());
    }

    @Test
    @DisplayName("Knight가 서남쪽으로 이동하는 것을 확인한다.")
    void verifyMovePositionToWestSouth() {
        // given
        board.initializeEmpty();

        Piece sourceKnight = Knight.createWhiteKnight(new Position("g4"));
        Piece targetKnight = Knight.createWhiteKnight(new Position("e3"));

        // when
        sourceKnight.verifyMovePosition(targetKnight, chessGame);

        // then
        assertEquals("e3", sourceKnight.getPosition().positionToString());
    }
}