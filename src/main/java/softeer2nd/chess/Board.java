package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Piece.Type;

import java.util.ArrayList;
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
        List<Piece> r = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            r.add(Piece.createWhitePawn(new Position(6, i)));
        }

        return new Rank(r);
    }

    public Rank createBlackPawn() {
        List<Piece> r = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            r.add(Piece.createBlackPawn(new Position(1, i)));
        }

        return new Rank(r);
    }

    public Rank createWhiteOthers() {
        List<Piece> r = new ArrayList<>();
        for (int i = 0; i < typeOrder.length; i++) {
            r.add(Piece.createPiece(WHITE, typeOrder[i], new Position(7, i)));
        }

        return new Rank(r);
    }

    public Rank createBlackOthers() {
        List<Piece> r = new ArrayList<>();

        for (int i = 0; i < typeOrder.length; i++) {
            r.add(Piece.createPiece(BLACK, typeOrder[i], new Position(0, i)));
        }

        return new Rank(r);
    }

    public Rank createBlank(int row) {
        List<Piece> r = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            r.add(Piece.createBlank(new Position(row, i)));
        }

        return new Rank(r);
    }

    public void initialSetPiece(String location, Piece piece) {
        Position position = new Position(location);

        List<Piece> r = new ArrayList<>(chessBoard.get(position.getY()).getRank());
        r.set(position.getX(), piece);
        chessBoard.set(position.getY(), new Rank(r));
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
