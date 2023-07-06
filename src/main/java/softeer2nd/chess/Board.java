package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Piece.Color;
import softeer2nd.chess.pieces.Piece.Type;
import softeer2nd.utils.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static softeer2nd.chess.Board.Position.createPosition;
import static softeer2nd.chess.pieces.Piece.Color.*;
import static softeer2nd.chess.pieces.Piece.Type.*;

public class Board {

    public static class Rank {
        private final List<Piece> rank = new ArrayList<>();
    }

    public static class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public static Position createPosition(String location) {
            int xPos = location.charAt(0) - 'a';
            int yPos = 8 - Character.getNumericValue(location.charAt(1));

            return new Position(xPos, yPos);
        }
    }

    private final List<Rank> chessBoard = new ArrayList<>();
    private Type[] typeOrder = new Type[] {ROOK, KNIGHT, BISHOP, QUEEN, KING, BISHOP, KNIGHT, ROOK};

    public Board() {
    }

    public Piece findPawn(int row, int col) {
        return chessBoard.get(row).rank.get(col);
    }

    public void initializeEmpty() {
        for (int i = 0; i < 8; i++) {
            chessBoard.add(createBlank());
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
                chessBoard.add(createBlank());
            }
        }
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            StringBuilder sb2 = new StringBuilder();
            chessBoard.get(i).rank.forEach(p -> {
                if (p.getColor().equals(WHITE) || p.getColor().equals(NO_COLOR)) {
                    sb2.append(p.getType().getRepresentation());
                } else {
                    sb2.append(Character.toUpperCase(p.getType().getRepresentation()));
                }
            });
            sb.append(StringUtils.appendNewLine(sb2.toString()));
        }

        return sb.toString();
    }

    public Rank createWhitePawn() {
        Rank rank = new Rank();
        for (int i = 0; i < 8; i++) {
            rank.rank.add(Piece.createWhitePawn());
        }
        return rank;
    }

    public Rank createBlackPawn() {
        Rank rank = new Rank();
        for (int i = 0; i < 8; i++) {
            rank.rank.add(Piece.createBlackPawn());
        }
        return rank;
    }

    public Rank createWhiteOthers() {
        Rank rank = new Rank();
        for (int i = 0; i < typeOrder.length; i++) {
            rank.rank.add(Piece.createPiece(WHITE, typeOrder[i]));
        }
        return rank;
    }

    public Rank createBlackOthers() {
        Rank rank = new Rank();
        for (int i = 0; i < typeOrder.length; i++) {
            rank.rank.add(Piece.createPiece(BLACK, typeOrder[i]));
        }
        return rank;
    }

    public Rank createBlank() {
        Rank rank = new Rank();
        for (int i = 0; i < 8; i++) {
            rank.rank.add(Piece.createBlank());
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
        Position position = createPosition(location);

        return chessBoard.get(position.getY()).rank.get(position.getX());
    }

    public void move(String location, Piece piece) {
        Position position = createPosition(location);

        chessBoard.get(position.getY()).rank.set(position.getX(), piece);
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
