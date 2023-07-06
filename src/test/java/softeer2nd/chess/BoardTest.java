package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Piece;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.chess.pieces.Piece.Color.*;
import static softeer2nd.chess.pieces.Piece.Color.BLACK;
import static softeer2nd.chess.pieces.Piece.Color.WHITE;
import static softeer2nd.chess.pieces.Piece.Type.*;
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

    @Test
    @DisplayName("기물의 색상과 종류가 주어지면 해당 기물의 개수를 반환해야 한다.")
    void pieceCountByColorAndType() {
        board.initialize();
        int count = board.pieceCountByColorAndType(WHITE, PAWN);
        assertEquals(8, count);

        count = board.pieceCountByColorAndType(BLACK, KNIGHT);
        assertEquals(2, count);
    }

    @Test
    @DisplayName("기물의 위치가 주어지면 해당 기물이 반환되어야 한다.")
    public void findPiece() throws Exception {
        board.initialize();

        assertEquals(BLACK, board.findPiece("a8").getColor());
        assertEquals(ROOK, board.findPiece("a8").getType());
        assertEquals(WHITE, board.findPiece("a1").getColor());
        assertEquals(ROOK, board.findPiece("a1").getType());;
    }

    @Test
    @DisplayName("빈 체스판을 생성하고 주어진 위치에 기물이 추가 되는지 확인한다.")
    public void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createBlackRook();
        board.move(position, piece);

        assertEquals(piece, board.findPiece(position));
        System.out.println(board.showBoard());

        position = "e3";
        piece = Piece.createWhiteKing();
        board.move(position, piece);

        assertEquals(piece, board.findPiece(position));
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("주어진 위치에 기물을 추가하고 색깔별로 점수 계산이 되는지 확인한다.")
    public void caculcatePoint() throws Exception {
        board.initializeEmpty();

        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());
        addPiece("b8", Piece.createBlackKing());
        addPiece("c8", Piece.createBlackRook());

        addPiece("f2", Piece.createWhitePawn());
        addPiece("g2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());
        addPiece("f1", Piece.createWhiteKing());

        assertEquals(15.0, board.caculcatePoint(BLACK), 0.01);
        assertEquals(7.0, board.caculcatePoint(WHITE), 0.01);

        System.out.println(board.showBoard());
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
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
