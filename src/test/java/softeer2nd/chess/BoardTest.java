package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Pawn;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    Board board;

    @BeforeEach
    public void create_board() {
        board = new Board();
    }

    @Test
    public void create() throws Exception {
        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        verifyInputPawn(white);

        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        verifyInputPawn(black);
    }

    @Test
    public void initialize() throws Exception {
        Board board = new Board();
        board.initialize();
        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
    }

    public void verifyInputPawn(Pawn pawn) {
        int size = board.size();

        board.add(pawn);
        verifySize(size + 1);
        verifyPawn(pawn);
    }

    public void verifySize(int size) {
        assertEquals(size, board.size());
    }

    public void verifyPawn(Pawn pawn) {
        assertEquals(pawn, board.findPawn(board.size() - 1));
    }

//    @Test
//    @DisplayName("Pawn 이외의 객체가 체스판에 입력되면 에러가 발생해야 한다.")
//    public void create_Pawn_이외_객체() {
//        Board board = new Board();
//
//        Integer num = new Integer("7");
//        board.add(num);
//    }
}
