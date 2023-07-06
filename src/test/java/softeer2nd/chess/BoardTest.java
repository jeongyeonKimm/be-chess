package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.ChessGame;
import softeer2nd.chess.pieces.Piece;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        assertEquals(32, ChessGame.pieceCount());
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                ChessView.showBoard());
    }

    @Test
    @DisplayName("기물의 색상과 종류가 주어지면 해당 기물의 개수를 반환해야 한다.")
    void pieceCountByColorAndType() {
        board.initialize();
        int count = ChessGame.pieceCountByColorAndType(WHITE, PAWN);
        assertEquals(8, count);

        count = ChessGame.pieceCountByColorAndType(BLACK, KNIGHT);
        assertEquals(2, count);
    }

    @Test
    @DisplayName("기물의 위치가 주어지면 해당 기물이 반환되어야 한다.")
    public void findPiece() throws Exception {
        board.initialize();

        assertEquals(BLACK, ChessGame.findPiece("a8").getColor());
        assertEquals(ROOK, ChessGame.findPiece("a8").getType());
        assertEquals(WHITE, ChessGame.findPiece("a1").getColor());
        assertEquals(ROOK, ChessGame.findPiece("a1").getType());;
    }

    @Test
    @DisplayName("빈 체스판을 생성하고 주어진 위치에 기물이 추가 되는지 확인한다.")
    public void initialSetPiece() throws Exception {
        board.initializeEmpty();
        String position = "b5";
        Piece piece = Piece.createBlackRook(new Position(position));
        board.initialSetPiece(position, piece);
        assertEquals(piece, ChessGame.findPiece(position));

        position = "e3";
        piece = Piece.createWhiteKing(new Position(position));
        board.initialSetPiece(position, piece);
        assertEquals(piece, ChessGame.findPiece(position));
    }

    @Test
    @DisplayName("기물이 source에서 target으로 이동하는지 확인한다.")
    public void move() throws Exception {
        board.initialize();

        String sourcePosition = "b2";
        String targetPosition = "b3";
        ChessGame.move(sourcePosition, targetPosition);
        assertEquals(Piece.createBlank(new Position(sourcePosition)).getColor(), ChessGame.findPiece(sourcePosition).getColor());
        assertEquals(Piece.createBlank(new Position(sourcePosition)).getType(), ChessGame.findPiece(sourcePosition).getType());
        assertEquals(Piece.createWhitePawn(new Position(targetPosition)).getColor(), ChessGame.findPiece(targetPosition).getColor());
        assertEquals(Piece.createWhitePawn(new Position(targetPosition)).getType(), ChessGame.findPiece(targetPosition).getType());
    }

    @Test
    @DisplayName("주어진 위치에 기물을 추가하고 색깔별로 점수 계산이 되는지 확인한다.")
    public void calculatePoint() throws Exception {
        board.initializeEmpty();

        addPiece("b6", Piece.createBlackPawn(new Position("b6")));
        addPiece("e6", Piece.createBlackQueen(new Position("e6")));
        addPiece("b8", Piece.createBlackKing(new Position("b8")));
        addPiece("c8", Piece.createBlackRook(new Position("e8")));

        addPiece("f2", Piece.createWhitePawn(new Position("f2")));
        addPiece("g2", Piece.createWhitePawn(new Position("g2")));
        addPiece("e1", Piece.createWhiteRook(new Position("e1")));
        addPiece("f1", Piece.createWhiteKing(new Position("f1")));

        System.out.println(ChessView.showBoard());

        assertEquals(15.0, ChessGame.calculatePoint(BLACK), 0.01);
        assertEquals(7.0, ChessGame.calculatePoint(WHITE), 0.01);

        System.out.println(ChessView.showBoard());
    }
//
    @Test
    @DisplayName("점수가 오름차순으로 정렬되는지 확인한다.")
    void sortAscByPoint() {
        board.initializeEmpty();

        addPiece("b6", Piece.createBlackPawn(new Position("b6")));
        addPiece("e6", Piece.createBlackQueen(new Position("e6")));
        addPiece("b8", Piece.createBlackKing(new Position("b8")));
        addPiece("c8", Piece.createBlackRook(new Position("e8")));

        addPiece("f2", Piece.createWhitePawn(new Position("f2")));
        addPiece("g2", Piece.createWhitePawn(new Position("g2")));
        addPiece("e1", Piece.createWhiteRook(new Position("e1")));
        addPiece("f1", Piece.createWhiteKing(new Position("f1")));

        List<Piece> blackList = ChessGame.sortAscByPoint(BLACK);
        assertEquals("KPRQ", blackList.stream()
                .map(p -> Character.toUpperCase(p.getType().getRepresentation()))
                .map(String::valueOf)
                .collect(Collectors.joining()));
    }

    @Test
    @DisplayName("점수가 내림차순으로 정렬되는지 확인한다.")
    void sortDescByPoint() {
        board.initializeEmpty();

        addPiece("b6", Piece.createBlackPawn(new Position("b6")));
        addPiece("e6", Piece.createBlackQueen(new Position("e6")));
        addPiece("b8", Piece.createBlackKing(new Position("b8")));
        addPiece("c8", Piece.createBlackRook(new Position("e8")));

        addPiece("f2", Piece.createWhitePawn(new Position("f2")));
        addPiece("g2", Piece.createWhitePawn(new Position("g2")));
        addPiece("e1", Piece.createWhiteRook(new Position("e1")));
        addPiece("f1", Piece.createWhiteKing(new Position("f1")));

        List<Piece> whiteList = ChessGame.sortDescByPoint(WHITE);
        assertEquals(whiteList.stream().map(p -> p.getType().getRepresentation()).map(String::valueOf).collect(Collectors.joining()), "rppk");
    }

    private void addPiece(String position, Piece piece) {
        board.initialSetPiece(position, piece);
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
