package softeer2nd.chess;

import softeer2nd.chess.pieces.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rank {
    private final List<Piece> rank;

    public Rank(List<Piece> rank) {
        this.rank = new ArrayList<>(rank);
    }

    public List<Piece> getRank() {
        return Collections.unmodifiableList(rank);
    }

    public void setPiece(Position position, Piece piece) {
        rank.set(position.getX(), piece);
    }

    public static Rank createWhitePawns() {
        List<Piece> r = new ArrayList<>();

        for (int i = 0; i < Board.BOARD_LENGTH; i++) {
            r.add(Pawn.createWhitePawn(new Position(i, 6)));
        }

        return new Rank(r);
    }

    public static Rank createBlackPawns() {
        List<Piece> r = new ArrayList<>();

        for (int i = 0; i < Board.BOARD_LENGTH; i++) {
            r.add(Pawn.createBlackPawn(new Position(i, 1)));
        }

        return new Rank(r);
    }

    public static Rank createWhiteOthers() {
        List<Piece> r = new ArrayList<>();

        r.add(Rook.createWhiteRook(new Position(0, 7)));
        r.add(Knight.createWhiteKnight(new Position(1, 7)));
        r.add(Bishop.createWhiteBishop(new Position(2, 7)));
        r.add(Queen.createWhiteQueen(new Position(3, 7)));
        r.add(King.createWhiteKing(new Position(4, 7)));
        r.add(Bishop.createWhiteBishop(new Position(5, 7)));
        r.add(Knight.createWhiteKnight(new Position(6, 7)));
        r.add(Rook.createWhiteRook(new Position(7, 7)));

        return new Rank(r);
    }

    public static Rank createBlackOthers() {
        List<Piece> r = new ArrayList<>();

        r.add(Rook.createBlackRook(new Position(0, 0)));
        r.add(Knight.createBlackKnight(new Position(1, 0)));
        r.add(Bishop.createBlackBishop(new Position(2, 0)));
        r.add(Queen.createBlackQueen(new Position(3, 0)));
        r.add(King.createBlackKing(new Position(4, 0)));
        r.add(Bishop.createBlackBishop(new Position(5, 0)));
        r.add(Knight.createBlackKnight(new Position(6, 0)));
        r.add(Rook.createBlackRook(new Position(7, 0)));

        return new Rank(r);
    }

    public static Rank createBlank(int row) {
        List<Piece> r = new ArrayList<>();

        for (int i = 0; i < Board.BOARD_LENGTH; i++) {
            r.add(Blank.createBlank(new Position(i, row)));
        }

        return new Rank(r);
    }
}
