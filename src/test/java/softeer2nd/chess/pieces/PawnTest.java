package softeer2nd.chess.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board;
import softeer2nd.chess.ChessGame;
import softeer2nd.chess.Position;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    private Board board;
    private ChessGame chessGame;

    @BeforeEach
    void create_board() {
        board = new Board();
        chessGame = new ChessGame(board);
    }

    @Test
    @DisplayName("초기 상태에 Pawn이 1칸 전진 가능한 것을 확인한다.")
    void verifyMovePositionInInitialState() {
        // given
        board.initializeEmpty();

        Piece sourcePawn = Pawn.createBlackPawn(new Position("d2"));
        Piece targetPawn = Blank.createBlank(new Position("d3"));

        // when
        sourcePawn.verifyMovePosition(targetPawn, chessGame);

        // then
        assertEquals("d3", sourcePawn.getPosition().positionToString());
    }

    @Test
    @DisplayName("초기 상태에 Pawn이 2칸 전진 가능한 것을 확인한다.")
    void verifyMovePositionInInitialState2() {
        // given
        board.initializeEmpty();

        Piece sourcePawn = Pawn.createBlackPawn(new Position("d2"));
        Piece targetPawn = Blank.createBlank(new Position("d4"));

        // when
        sourcePawn.verifyMovePosition(targetPawn, chessGame);

        // then
        assertEquals("d4", sourcePawn.getPosition().positionToString());
    }

    @Test
    @DisplayName("초기 상태가 아닐 때 Pawn이 1칸 전진 가능한 것을 확인한다.")
    void verifyMovePosition() {
        // given
        board.initializeEmpty();

        Piece sourcePawn = Pawn.createBlackPawn(new Position("d2"));
        Piece targetPawn = Blank.createBlank(new Position("d4"));

        sourcePawn.verifyMovePosition(targetPawn, chessGame);

        targetPawn = Blank.createBlank(new Position("d5"));

        // when
        sourcePawn.verifyMovePosition(targetPawn, chessGame);

        // then
        assertEquals("d5", sourcePawn.getPosition().positionToString());
    }

    @Test
    @DisplayName("대각선에 있는 다른 편 기물을 Pawn이 잡을 수 있는 것을 확인한다.")
    void verifyMovePositionOnDiagonal() {
        // given
        board.initializeEmpty();

        Piece sourcePawn = Pawn.createBlackPawn(new Position("d2"));
        Piece targetPawn = Pawn.createWhitePawn(new Position("c3"));

        // when
        sourcePawn.verifyMovePosition(targetPawn, chessGame);

        // then
        assertEquals("c3", sourcePawn.getPosition().positionToString());
    }

}