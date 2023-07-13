package softeer2nd.chess;

import softeer2nd.chess.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public static final int BOARD_LENGTH = 8;
    private static final int BLACK_OTHERS_RANK_NUM = 0;
    private static final int BLACK_PAWNS_RANK_NUM = 1;
    private static final int WHITE_PAWNS_RANK_NUM = 6;
    private static final int WHITE_OTHERS_RANK_NUM = 7;


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
            if (i == BLACK_OTHERS_RANK_NUM) {
                chessBoard.add(Rank.createBlackOthers());
            } else if (i == BLACK_PAWNS_RANK_NUM) {
                chessBoard.add(Rank.createBlackPawns());
            } else if (i == WHITE_PAWNS_RANK_NUM) {
                chessBoard.add(Rank.createWhitePawns());
            } else if (i == WHITE_OTHERS_RANK_NUM) {
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
            if (i == BLACK_OTHERS_RANK_NUM ||
                    i == BLACK_PAWNS_RANK_NUM ||
                    i == WHITE_PAWNS_RANK_NUM ||
                    i == WHITE_OTHERS_RANK_NUM) {
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
