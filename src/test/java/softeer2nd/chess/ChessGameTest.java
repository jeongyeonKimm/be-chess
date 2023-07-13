package softeer2nd.chess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.exception.*;
import softeer2nd.chess.pieces.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.chess.pieces.Color.BLACK;
import static softeer2nd.chess.pieces.Color.WHITE;
import static softeer2nd.chess.pieces.Type.*;

class ChessGameTest {

    private Board board;
    private ChessGame chessGame;

    @BeforeEach
    public void create_board() {
        board = new Board();
        chessGame = new ChessGame(board);
    }

    @Test
    @DisplayName("기물의 위치가 주어지면 해당 기물이 반환되어야 한다.")
    void findPiece() throws Exception {
        board.initialize();

        assertEquals(BLACK, board.findPiece(new Position("a8")).getColor());
        assertEquals(ROOK, board.findPiece(new Position("a8")).getType());
        assertEquals(WHITE, board.findPiece(new Position("a1")).getColor());
        assertEquals(ROOK, board.findPiece(new Position("a1")).getType());;
    }

    @Test
    @DisplayName("기물이 source에서 target으로 이동하는지 확인한다.")
    void move() throws Exception {
        // given
        board.initialize();

        String sourcePosition = "b2";
        String targetPosition = "b3";
        boolean isWhiteTurn = true;

        // when
        chessGame.move(sourcePosition, targetPosition, isWhiteTurn);

        // then
        assertEquals(NO_PIECE, board.findPiece(new Position(sourcePosition)).getType());
        assertEquals(PAWN, board.findPiece(new Position(targetPosition)).getType());
    }

    @Test
    @DisplayName("source와 target이 체스판 안에 있는지 확인한다.")
    void verifyChessBoardBound() throws Exception {
        // given
        board.initialize();

        String sourcePosition = "a9";
        String targetPosition = "a7";
        boolean isWhiteTurn = true;

        // when
        // then
        Assertions.assertThrows(BoardOutOfBounds.class, () -> {
            chessGame.move(sourcePosition, targetPosition, isWhiteTurn);
        });
    }

    @Test
    @DisplayName("souce와 target이 같은 경우 예외가 발생을 확인한다.")
    void verifyPresentPosition() throws Exception {
        // given
        board.initialize();

        String sourcePosition = "b2";
        String targetPosition = "b2";
        boolean isWhiteTurn = true;

        // when
        // then
        Assertions.assertThrows(InvalidTargetPosition.class, () -> {
            chessGame.move(sourcePosition, targetPosition, isWhiteTurn);
        });
    }

    @Test
    @DisplayName("흰색 기물 차례를 확인한다.")
    void verifyPieceTurn() throws Exception {
        // given
        board.initialize();

        String sourcePosition = "b7";
        String targetPosition = "b6";
        boolean isWhiteTurn = true;

        // when
        // then
        Assertions.assertThrows(IllegalTurnException.class, () -> {
            chessGame.move(sourcePosition, targetPosition, isWhiteTurn);
        });
    }

    @Test
    @DisplayName("해당 위치에 기물이 있는지 확인한다.")
    void verifyEmptyPiece() throws Exception {
        // given
        board.initialize();

        String sourcePosition = "b5";
        String targetPosition = "b6";
        boolean isWhiteTurn = true;

        // when
        // then
        Assertions.assertThrows(EmptyPieceException.class, () -> {
            chessGame.move(sourcePosition, targetPosition, isWhiteTurn);
        });
    }

    @Test
    @DisplayName("target에 같은 편 기물이 있는지 확인한다.")
    void verifySameTeamOnTarget() throws Exception {
        // given
        board.initialize();

        String sourcePosition = "a1";
        String targetPosition = "a2";
        boolean isWhiteTurn = true;

        // when
        // then
        Assertions.assertThrows(ExistSameColorPiece.class, () -> {
            chessGame.move(sourcePosition, targetPosition, isWhiteTurn);
        });
    }

    @Test
    @DisplayName("이동 경로에 다른 기물이 있는지 확인한다.")
    void verifyOtherPieceOnPath() throws Exception {
        // given
        board.initialize();

        String sourcePosition = "a1";
        String targetPosition = "a5";
        boolean isWhiteTurn = true;

        // when
        // then
        Assertions.assertThrows(ExistSameColorPiece.class, () -> {
            chessGame.move(sourcePosition, targetPosition, isWhiteTurn);
        });
    }


    @Test
    @DisplayName("주어진 위치에 기물을 추가하고 색깔별로 점수 계산이 되는지 확인한다.")
    void calculatePoint() throws Exception {
        board.initializeEmpty();

        addPiece("b6", Pawn.createBlackPawn(new Position("b6")));
        addPiece("e6", Queen.createBlackQueen(new Position("e6")));
        addPiece("b8", King.createBlackKing(new Position("b8")));
        addPiece("c8", Rook.createBlackRook(new Position("e8")));

        addPiece("f2", Pawn.createWhitePawn(new Position("f2")));
        addPiece("g2", Pawn.createWhitePawn(new Position("g2")));
        addPiece("e1", Rook.createWhiteRook(new Position("e1")));
        addPiece("f1", King.createWhiteKing(new Position("f1")));

        assertEquals(15.0, chessGame.calculatePoint(BLACK), 0.01);
        assertEquals(7.0, chessGame.calculatePoint(WHITE), 0.01);
    }

    @Test
    @DisplayName("점수가 오름차순으로 정렬되는지 확인한다.")
    void sortAscByPoint() {
        board.initializeEmpty();

        addPiece("b6", Pawn.createBlackPawn(new Position("b6")));
        addPiece("e6", Queen.createBlackQueen(new Position("e6")));
        addPiece("b8", King.createBlackKing(new Position("b8")));
        addPiece("c8", Rook.createBlackRook(new Position("e8")));

        addPiece("f2", Pawn.createWhitePawn(new Position("f2")));
        addPiece("g2", Pawn.createWhitePawn(new Position("g2")));
        addPiece("e1", Rook.createWhiteRook(new Position("e1")));
        addPiece("f1", King.createWhiteKing(new Position("f1")));

        List<Piece> blackList = chessGame.sortByPointAsc(BLACK);
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

        addPiece("b6", Pawn.createBlackPawn(new Position("b6")));
        addPiece("e6", Queen.createBlackQueen(new Position("e6")));
        addPiece("b8", King.createBlackKing(new Position("b8")));
        addPiece("c8", Rook.createBlackRook(new Position("e8")));

        addPiece("f2", Pawn.createWhitePawn(new Position("f2")));
        addPiece("g2", Pawn.createWhitePawn(new Position("g2")));
        addPiece("e1", Rook.createWhiteRook(new Position("e1")));
        addPiece("f1", King.createWhiteKing(new Position("f1")));

        List<Piece> whiteList = chessGame.sortByPointDesc(WHITE);
        assertEquals(whiteList.stream()
                .map(p -> p.getType().getRepresentation())
                .map(String::valueOf)
                .collect(Collectors.joining()), "rppk");
    }

    private void addPiece(String position, Piece piece) {
        board.initialSetPiece(position, piece);
    }
}
