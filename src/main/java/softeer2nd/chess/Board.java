package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Piece.Color;
import softeer2nd.chess.pieces.Piece.Type;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static softeer2nd.chess.pieces.Piece.Color.*;
import static softeer2nd.chess.pieces.Piece.Type.*;

public class Board {

    private Type[] typeOrder = new Type[] {ROOK, KNIGHT, BISHOP, QUEEN, KING, BISHOP, KNIGHT, ROOK};
    private final List<Rank> chessBoard = new ArrayList<>();

    public List<Rank> getChessBoard() {
        return chessBoard;
    }

    public Board() {
    }

    public Piece findPawn(int row, int col) {
        return chessBoard.get(row).getRank().get(col);
    }

    public void initializeEmpty() {
        for (int i = 0; i < 8; i++) {
            chessBoard.add(createBlank(i));
        }
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            if (i == 0) {
                chessBoard.add(createBlackOthers());
            } else if (i == 1) {
                chessBoard.add(createBlackPawn());
            } else if (i == 6) {
                chessBoard.add(createWhitePawn());
            } else if (i == 7) {
                chessBoard.add(createWhiteOthers());
            } else {
                chessBoard.add(createBlank(i));
            }
        }
    }

    public Rank createWhitePawn() {
        Rank rank = new Rank();
        for (int i = 0; i < 8; i++) {
            rank.getRank().add(Piece.createWhitePawn(new Position(6, i)));
        }
        return rank;
    }

    public Rank createBlackPawn() {
        Rank rank = new Rank();
        for (int i = 0; i < 8; i++) {
            rank.getRank().add(Piece.createBlackPawn(new Position(1, i)));
        }
        return rank;
    }

    public Rank createWhiteOthers() {
        Rank rank = new Rank();
        for (int i = 0; i < typeOrder.length; i++) {
            rank.getRank().add(Piece.createPiece(WHITE, typeOrder[i], new Position(7, i)));
        }
        return rank;
    }

    public Rank createBlackOthers() {
        Rank rank = new Rank();
        for (int i = 0; i < typeOrder.length; i++) {
            rank.getRank().add(Piece.createPiece(BLACK, typeOrder[i], new Position(0, i)));
        }
        return rank;
    }

    public Rank createBlank(int row) {
        Rank rank = new Rank();
        for (int i = 0; i < 8; i++) {
            rank.getRank().add(Piece.createBlank(new Position(row, i)));
        }
        return rank;
    }

    public void initialSetPiece(String location, Piece piece) {
        Position position = new Position(location);

        chessBoard.get(position.getY()).getRank().set(position.getX(), piece);
    }

    public int pieceCount() {
        int size = 0;
        for (int i = 0; i < chessBoard.size(); i++) {
            if (i == 0 || i == 1 || i == 6 || i == 7) {
                size += chessBoard.get(i).getRank().size();
            }
        }
        return size;
    }

    public int pieceCountByColorAndType(Piece.Color color, Piece.Type type) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            count += (int) chessBoard.get(i).getRank()
                    .stream()
                    .filter(p -> p.getColor().equals(color) && p.getType().equals(type)).count();
        }
        return count;
    }
}
