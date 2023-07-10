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
        board.initialize();

        Piece sourceRook = chessGame.findPiece("a1");
        sourceRook.setNewPosition(new Position("a3"));

        Position target = new Position("c3");
        Piece targetRook = Piece.createPiece(Color.NO_COLOR, Type.NO_PIECE, target);

        // when
        sourceRook.verifyMovePosition(targetRook, chessGame);

        // then
        assertEquals("c3", sourceRook.getPosition().positionToString());
    }

    @Test
    @DisplayName("Rook이 서쪽으로 2칸 이동하는 것을 확인한다.")
    void verifyMovePositionToWest() {
        // given
        board.initialize();

        Piece sourceRook = chessGame.findPiece("h1");
        sourceRook.setNewPosition(new Position("h3"));

        Position target = new Position("f3");
        Piece targetRook = Piece.createPiece(Color.NO_COLOR, Type.NO_PIECE, target);

        // when
        sourceRook.verifyMovePosition(targetRook, chessGame);

        // then
        assertEquals("f3", sourceRook.getPosition().positionToString());
    }

    @Test
    @DisplayName("Rook이 북쪽으로 3칸 이동하는 것을 확인한다.")
    void verifyMovePositionToNorth() {
        // given
        board.initialize();

        Piece sourceRook = chessGame.findPiece("a1");
        sourceRook.setNewPosition(new Position("a3"));

        Position target = new Position("a6");
        Piece targetRook = Piece.createPiece(Color.NO_COLOR, Type.NO_PIECE, target);

        // when
        sourceRook.verifyMovePosition(targetRook, chessGame);

        // then
        assertEquals("a6", sourceRook.getPosition().positionToString());
    }

    @Test
    @DisplayName("Rook이 남쪽으로 3칸 이동하는 것을 확인한다.")
    void verifyMovePositionToSouth() {
        // given
        board.initialize();

        Piece sourceRook = chessGame.findPiece("h1");
        sourceRook.setNewPosition(new Position("h6"));

        Position target = new Position("h3");
        Piece targetRook = Piece.createPiece(Color.NO_COLOR, Type.NO_PIECE, target);

        // when
        sourceRook.verifyMovePosition(targetRook, chessGame);

        // then
        assertEquals("h3", sourceRook.getPosition().positionToString());
    }
}