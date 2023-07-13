package softeer2nd.chess;

import softeer2nd.chess.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public static final int BOARD_LENGTH = 8;

    private final List<Rank> chessBoard = new ArrayList<>();

    public Board() {
    }

    public List<Rank> getChessBoard() {
        return chessBoard;
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

        chessBoard.get(position.getY()).setPiece(position, piece);
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
}
