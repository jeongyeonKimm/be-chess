package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.utils.StringUtils.appendNewLine;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void create_board() {
        board = new Board();
    }

    @Test
    public void initialize() throws Exception {
        board.initialize();
        assertEquals(32, board.pieceCount());
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                board.showBoard());
    }

//    public void verifyPawn(Pawn pawn) {
//        assertEquals(pawn, board.findPawn(board.size() - 1));
//    }

//    @Test
//    @DisplayName("Pawn 이외의 객체가 체스판에 입력되면 에러가 발생해야 한다.")
//    public void create_Pawn_이외_객체() {
//        Board board = new Board();
//
//        Integer num = new Integer("7");
//        board.add(num);
//    }
}
