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
    public static class Rank {

        private List<Piece> rank = new ArrayList<>();

        public List<Piece> getRank() {
            return rank;
        }
    }

    private Type[] typeOrder = new Type[] {ROOK, KNIGHT, BISHOP, QUEEN, KING, BISHOP, KNIGHT, ROOK};
    private static final List<Rank> chessBoard = new ArrayList<>();

    public static List<Rank> getChessBoard() {
        return chessBoard;
    }

    public Board() {
    }

    public Piece findPawn(int row, int col) {
        return chessBoard.get(row).rank.get(col);
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
            rank.rank.add(Piece.createWhitePawn(new Position(6, i)));
        }
        return rank;
    }

    public Rank createBlackPawn() {
        Rank rank = new Rank();
        for (int i = 0; i < 8; i++) {
            rank.rank.add(Piece.createBlackPawn(new Position(1, i)));
        }
        return rank;
    }

    public Rank createWhiteOthers() {
        Rank rank = new Rank();
        for (int i = 0; i < typeOrder.length; i++) {
            rank.rank.add(Piece.createPiece(WHITE, typeOrder[i], new Position(7, i)));
        }
        return rank;
    }

    public Rank createBlackOthers() {
        Rank rank = new Rank();
        for (int i = 0; i < typeOrder.length; i++) {
            rank.rank.add(Piece.createPiece(BLACK, typeOrder[i], new Position(0, i)));
        }
        return rank;
    }

    public Rank createBlank(int row) {
        Rank rank = new Rank();
        for (int i = 0; i < 8; i++) {
            rank.rank.add(Piece.createBlank(new Position(row, i)));
        }
        return rank;
    }

    public int pieceCount() {
        int size = 0;
        for (int i = 0; i < chessBoard.size(); i++) {
            if (i == 0 || i == 1 || i == 6 || i == 7) {
                size += chessBoard.get(i).rank.size();
            }
        }
        return size;
    }

    public int pieceCountByColorAndType(Color color, Type type) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            count += (int) chessBoard.get(i).rank.stream().filter(p -> p.getColor().equals(color) && p.getType().equals(type)).count();
        }
        return count;
    }

    public Piece findPiece(String location) {
        Position position = new Position(location);

        return chessBoard.get(position.getY()).rank.get(position.getX());
    }

    public void initialSetPiece(String location, Piece piece) {
        Position position = new Position(location);

        chessBoard.get(position.getY()).rank.set(position.getX(), piece);
    }

    public void move(String source, String target) {
        Position sourcePos = new Position(source);
        Position targetPos = new Position(target);

        Piece findPiece = findPiece(source);
        chessBoard
                .get(targetPos.getY())
                .rank
                .set(targetPos.getX(), Piece.createPiece(findPiece.getColor(), findPiece.getType(), targetPos));
        chessBoard.get(sourcePos.getY()).rank.set(sourcePos.getX(), Piece.createBlank(sourcePos));
    }

    public double calculatePoint(Color color) {
        double totalPoint = 0;

        if (color.equals(WHITE)) {
            for (int i = 0; i < 8; i++) {
                totalPoint += getTotalPoint(i, WHITE);
            }
        } else if (color.equals(BLACK)){
            for (int i = 0; i < 8; i++) {
                totalPoint += getTotalPoint(i, BLACK);
            }
        }

        return totalPoint;
    }

    private double getTotalPoint(int row, Color color) {
        double totalPoint = 0;
        List<Piece> pieces = chessBoard.get(row).rank;

        for (Piece piece : pieces) {
            if (piece.getColor().equals(color)) {
                totalPoint += getPiecePoint(piece, row, pieces.indexOf(piece));
            }
        }
        return totalPoint;
    }

    private double getPiecePoint(Piece piece, int row, int col) {
        double piecePoint = piece.getType().getDefaultPoint();

        if (piece.getType().equals(PAWN) && existPawn(piece.getColor(), row, col)) {
            piecePoint = 0.5;
        }

        return piecePoint;
    }

    private boolean existPawn(Color color, int row, int col) {
        boolean flag = false;
        for (int i = 0; i < 8; i++) {
            Piece piece = chessBoard.get(i).rank.get(col);
            if (piece.getType().equals(PAWN) && piece.getColor().equals(color) && i != row) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public List<Piece> sortAscByPoint(Color color) {
        List<Piece> pieceList = new ArrayList<>();
        for (Rank rank : chessBoard) {
            rank.rank.stream().filter(p -> p.getColor().equals(color)).forEach(pieceList::add);
        }

        pieceList.sort(Comparator.comparingDouble(piece -> piece.getType().getDefaultPoint()));

        return pieceList;
    }

    public List<Piece> sortDescByPoint(Color color) {
        List<Piece> pieceList = new ArrayList<>();
        for (Rank rank : chessBoard) {
            rank.rank.stream().filter(p -> p.getColor().equals(color)).forEach(pieceList::add);
        }

        pieceList.sort(Comparator.comparingDouble(piece -> -piece.getType().getDefaultPoint()));

        return pieceList;
    }
}
