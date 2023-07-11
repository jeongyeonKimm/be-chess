package softeer2nd.chess;

import softeer2nd.chess.exception.BoardOutOfBounds;
import softeer2nd.chess.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final int BOARD_LENGTH = 8;

    private final List<Rank> chessBoard = new ArrayList<>();

    public List<Rank> getChessBoard() {
        return chessBoard;
    }

    public Board() {
    }

    public Piece findPiece(Position position) {
        return chessBoard.get(position.getY()).getRank().get(position.getX());
    }

    public void initializeEmpty() {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            chessBoard.add(Rank.createBlank(i));
        }
    }

    public void initialize() {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            if (i == 0) {
                chessBoard.add(Rank.createBlackOthers());
            } else if (i == 1) {
                chessBoard.add(Rank.createBlackPawns());
            } else if (i == 6) {
                chessBoard.add(Rank.createWhitePawns());
            } else if (i == 7) {
                chessBoard.add(Rank.createWhiteOthers());
            } else {
                chessBoard.add(Rank.createBlank(i));
            }
        }
    }

    public void initialSetPiece(String location, Piece piece) {
        Position position = new Position(location);

        List<Piece> r = new ArrayList<>(chessBoard.get(position.getY()).getRank());
        r.set(position.getX(), piece);
        chessBoard.set(position.getY(), new Rank(r));
    }

    public int pieceCount() {
        int size = 0;
        for (int i = 0; i < BOARD_LENGTH; i++) {
            if (i == 0 || i == 1 || i == 6 || i == 7) {
                size += chessBoard.get(i).getRank().size();
            }
        }
        return size;
    }

    public int pieceCountByColorAndType(Color color, Type type) {
        int count = 0;
        for (int i = 0; i < BOARD_LENGTH; i++) {
            count += (int) chessBoard.get(i).getRank()
                    .stream()
                    .filter(p -> p.getColor().equals(color) && p.getType().equals(type))
                    .count();
        }
        return count;
    }

    public void verifyChessBoardBound(Position target) {
        if (target.getX() >= 0 && target.getX() < BOARD_LENGTH &&
                target.getY() >= 0 && target.getY() < BOARD_LENGTH) {
            return;
        }

        throw new BoardOutOfBounds("체스판 밖으로 이동할 수 없습니다.");
    }
}
