package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Piece;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.chess.pieces.Piece.Color.BLACK;
import static softeer2nd.chess.pieces.Piece.Color.WHITE;
import static softeer2nd.chess.pieces.Piece.Type.KNIGHT;
import static softeer2nd.chess.pieces.Piece.Type.PAWN;
import static softeer2nd.utils.StringUtils.appendNewLine;

public class BoardTest {

    private Board board;
    private ChessGame chessGame;
    private ChessView chessView;

    @BeforeEach
    public void create_board() {
        board = new Board();
        chessGame = new ChessGame(board);
        chessView = new ChessView(board);
    }

    @Test
    @DisplayName("체스판을 초기화 한다.")
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
                chessView.showBoard());
    }

    @Test
    @DisplayName("기물의 색상과 종류가 주어지면 해당 기물의 개수를 반환해야 한다.")
    void pieceCountByColorAndType() throws Exception {
        board.initialize();
        int count = board.pieceCountByColorAndType(WHITE, PAWN);
        assertEquals(8, count);

        count = board.pieceCountByColorAndType(BLACK, KNIGHT);
        assertEquals(2, count);
    }

    @Test
    @DisplayName("빈 체스판을 생성하고 주어진 위치에 기물이 추가 되는지 확인한다.")
    public void initialSetPiece() throws Exception {
        board.initializeEmpty();
        String position = "b5";
        Piece piece = Piece.createBlackRook(new Position(position));
        board.initialSetPiece(position, piece);
        assertEquals(piece, chessGame.findPiece(position));

        position = "e3";
        piece = Piece.createWhiteKing(new Position(position));
        board.initialSetPiece(position, piece);
        assertEquals(piece, chessGame.findPiece(position));
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
