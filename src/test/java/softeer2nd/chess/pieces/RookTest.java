package softeer2nd.chess.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board;
import softeer2nd.chess.ChessGame;
import softeer2nd.chess.Position;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {

    private Board board;
    private ChessGame chessGame;

    @BeforeEach
    void create_board() {
        board = new Board();
        chessGame = new ChessGame(board);
    }

    @Test
    @DisplayName("Rook이 동쪽으로 2칸 이동하는 것을 확인한다.")
    void verifyMovePositionToEast() {
        // given
        board.initializeEmpty();

        Piece sourceRook = Rook.createWhiteRook(new Position("a3"));
        Piece targetRook = Rook.createWhiteRook(new Position("c3"));

        // when
        sourceRook.verifyMovePosition(targetRook, chessGame);

        // then
        assertEquals("c3", sourceRook.getPosition().positionToString());
    }

    @Test
    @DisplayName("Rook이 서쪽으로 2칸 이동하는 것을 확인한다.")
    void verifyMovePositionToWest() {
        // given
        board.initializeEmpty();

        Piece sourceRook = Rook.createWhiteRook(new Position("h3"));
        Piece targetRook = Rook.createWhiteRook(new Position("f3"));

        // when
        sourceRook.verifyMovePosition(targetRook, chessGame);

        // then
        assertEquals("f3", sourceRook.getPosition().positionToString());
    }

    @Test
    @DisplayName("Rook이 북쪽으로 3칸 이동하는 것을 확인한다.")
    void verifyMovePositionToNorth() {
        // given
        board.initializeEmpty();

        Piece sourceRook = Rook.createWhiteRook(new Position("a3"));
        Piece targetRook = Rook.createWhiteRook(new Position("a6"));

        // when
        sourceRook.verifyMovePosition(targetRook, chessGame);

        // then
        assertEquals("a6", sourceRook.getPosition().positionToString());
    }

    @Test
    @DisplayName("Rook이 남쪽으로 3칸 이동하는 것을 확인한다.")
    void verifyMovePositionToSouth() {
        // given
        board.initializeEmpty();

        Piece sourceRook = Rook.createWhiteRook(new Position("h6"));
        Piece targetRook = Rook.createWhiteRook(new Position("h3"));

        // when
        sourceRook.verifyMovePosition(targetRook, chessGame);

        // then
        assertEquals("h3", sourceRook.getPosition().positionToString());
    }
}