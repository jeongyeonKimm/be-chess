package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.ChessGame;
import softeer2nd.chess.pieces.Piece;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.chess.pieces.Piece.Color.BLACK;
import static softeer2nd.chess.pieces.Piece.Color.WHITE;
import static softeer2nd.chess.pieces.Piece.Type.ROOK;

public class ChessGameTest {

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
    @DisplayName("기물의 위치가 주어지면 해당 기물이 반환되어야 한다.")
    public void findPiece() throws Exception {
        board.initialize();

        assertEquals(BLACK, chessGame.findPiece("a8").getColor());
        assertEquals(ROOK, chessGame.findPiece("a8").getType());
        assertEquals(WHITE, chessGame.findPiece("a1").getColor());
        assertEquals(ROOK, chessGame.findPiece("a1").getType());;
    }

    @Test
    @DisplayName("기물이 source에서 target으로 이동하는지 확인한다.")
    public void move() throws Exception {
        board.initialize();

        String sourcePosition = "b2";
        String targetPosition = "b3";
        chessGame.move(sourcePosition, targetPosition);
        assertThat(Piece.createBlank(new Position(sourcePosition))).isEqualToComparingFieldByFieldRecursively(chessGame.findPiece(sourcePosition));
        assertThat(Piece.createWhitePawn(new Position(targetPosition))).isEqualToComparingFieldByFieldRecursively(chessGame.findPiece(targetPosition));
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

        System.out.println(chessView.showBoard());

        assertEquals(15.0, chessGame.calculatePoint(BLACK), 0.01);
        assertEquals(7.0, chessGame.calculatePoint(WHITE), 0.01);

        System.out.println(chessView.showBoard());
    }

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

        List<Piece> blackList = chessGame.sortAscByPoint(BLACK);
        assertEquals("KPRQ", blackList
                .stream()
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

        List<Piece> whiteList = chessGame.sortDescByPoint(WHITE);
        assertEquals(whiteList.stream()
                .map(p -> p.getType().getRepresentation())
                .map(String::valueOf)
                .collect(Collectors.joining()), "rppk");
    }

    private void addPiece(String position, Piece piece) {
        board.initialSetPiece(position, piece);
    }
}
