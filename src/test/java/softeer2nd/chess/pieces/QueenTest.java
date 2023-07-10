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
    private ChessGame chessGame;

    @BeforeEach
    void create_board() {
        board = new Board();
        chessGame = new ChessGame(board);
    }

    @Test
    @DisplayName("Queen이 북동쪽으로 3칸 이동하는 것을 확인한다.")
    void verifyMovePositionToNorthEast() {
        // given
        board.initializeEmpty();

        Piece sourceKing = Queen.createBlackQueen(new Position("d4"));
        Piece targetKing = Blank.createBlank(new Position("g7"));

        // when
        sourceKing.verifyMovePosition(targetKing, chessGame);

        // then
        assertEquals("g7", sourceKing.getPosition().positionToString());
    }

    @Test
    @DisplayName("Queen이 동쪽으로 4칸 이동하는 것을 확인한다.")
    void verifyMovePositionToEast() {
        // given
        board.initializeEmpty();

        Piece sourceKing = Queen.createBlackQueen(new Position("d4"));
        Piece targetKing = Blank.createBlank(new Position("h4"));

        // when
        sourceKing.verifyMovePosition(targetKing, chessGame);

        // then
        assertEquals("h4", sourceKing.getPosition().positionToString());
    }

    @Test
    @DisplayName("Queen이 남동쪽으로 2칸 이동하는 것을 확인한다.")
    void verifyMovePositionToSouthEast() {
        // given
        board.initializeEmpty();

        Piece sourceKing = Queen.createBlackQueen(new Position("d4"));
        Piece targetKing = Blank.createBlank(new Position("f2"));

        // when
        sourceKing.verifyMovePosition(targetKing, chessGame);

        // then
        assertEquals("f2", sourceKing.getPosition().positionToString());
    }

    @Test
    @DisplayName("Queen이 남쪽으로 3칸 이동하는 것을 확인한다.")
    void verifyMovePositionToSouth() {
        // given
        board.initializeEmpty();

        Piece sourceKing = Queen.createBlackQueen(new Position("d4"));
        Piece targetKing = Blank.createBlank(new Position("d1"));

        // when
        sourceKing.verifyMovePosition(targetKing, chessGame);

        // then
        assertEquals("d1", sourceKing.getPosition().positionToString());
    }

    @Test
    @DisplayName("Queen이 남서쪽으로 2칸 이동하는 것을 확인한다.")
    void verifyMovePositionToSouthWest() {
        // given
        board.initializeEmpty();

        Piece sourceKing = Queen.createBlackQueen(new Position("d4"));
        Piece targetKing = Blank.createBlank(new Position("a1"));

        // when
        sourceKing.verifyMovePosition(targetKing, chessGame);

        // then
        assertEquals("a1", sourceKing.getPosition().positionToString());
    }

    @Test
    @DisplayName("Queen이 서쪽으로 1칸 이동하는 것을 확인한다.")
    void verifyMovePositionToWest() {
        // given
        board.initializeEmpty();

        Piece sourceKing = Queen.createBlackQueen(new Position("d4"));
        Piece targetKing = Blank.createBlank(new Position("c4"));

        // when
        sourceKing.verifyMovePosition(targetKing, chessGame);

        // then
        assertEquals("c4", sourceKing.getPosition().positionToString());
    }

    @Test
    @DisplayName("Queen이 북서쪽으로 2칸 이동하는 것을 확인한다.")
    void verifyMovePositionToNorthWest() {
        // given
        board.initializeEmpty();

        Piece sourceKing = Queen.createBlackQueen(new Position("d4"));
        Piece targetKing = Blank.createBlank(new Position("b6"));

        // when
        sourceKing.verifyMovePosition(targetKing, chessGame);

        // then
        assertEquals("b6", sourceKing.getPosition().positionToString());
    }

    @Test
    @DisplayName("Queen이 북쪽으로 4칸 이동하는 것을 확인한다.")
    void verifyMovePositionToNorth() {
        // given
        board.initializeEmpty();

        Piece sourceKing = Queen.createBlackQueen(new Position("d4"));
        Piece targetKing = Blank.createBlank(new Position("d8"));

        // when
        sourceKing.verifyMovePosition(targetKing, chessGame);

        // then
        assertEquals("d8", sourceKing.getPosition().positionToString());
    }

    @Test
    @DisplayName("Queen이 이동 에러")
    void verifyMovePosition() {
        // given
        board.initializeEmpty();

        Piece sourceKing = Queen.createBlackQueen(new Position("d4"));
        Piece targetKing = Blank.createBlank(new Position("g6"));

        // when
        sourceKing.verifyMovePosition(targetKing, chessGame);

        // then
        assertEquals("g6", sourceKing.getPosition().positionToString());
    }
}