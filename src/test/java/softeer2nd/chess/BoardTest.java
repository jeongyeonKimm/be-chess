package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.King;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Rook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.chess.pieces.Color.BLACK;
import static softeer2nd.chess.pieces.Color.WHITE;
import static softeer2nd.chess.pieces.Type.KNIGHT;
import static softeer2nd.chess.pieces.Type.PAWN;
import static softeer2nd.utils.StringUtils.appendNewLine;

class BoardTest {

    private Board board;
    private ChessGame chessGame;
    private ChessView chessView;

    @BeforeEach
    void create_board() {
        board = new Board();
        chessGame = new ChessGame(board);
        chessView = new ChessView(board);
    }

    @Test
    @DisplayName("체스판을 초기화 한다.")
    void initialize() throws Exception {
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
    void initialSetPiece() throws Exception {
        board.initializeEmpty();
        String position = "b5";
        Piece piece = Rook.createBlackRook(new Position(position));
        board.initialSetPiece(position, piece);
        assertEquals(piece, board.findPiece(new Position(position)));

        position = "e3";
        piece = King.createWhiteKing(new Position(position));
        board.initialSetPiece(position, piece);
        assertEquals(piece, board.findPiece(new Position(position)));
    }
}
