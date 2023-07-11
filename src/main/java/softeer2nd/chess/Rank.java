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

    public static Rank createWhitePawns() {
        List<Piece> r = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            r.add(Pawn.createWhitePawn(new Position(6, i)));
        }

        return new Rank(r);
    }

    public static Rank createBlackPawns() {
        List<Piece> r = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            r.add(Pawn.createBlackPawn(new Position(1, i)));
        }

        return new Rank(r);
    }

    public static Rank createWhiteOthers() {
        List<Piece> r = new ArrayList<>();

        r.add(Rook.createWhiteRook(new Position(7, 0)));
        r.add(Knight.createWhiteKnight(new Position(7, 1)));
        r.add(Bishop.createWhiteBishop(new Position(7, 2)));
        r.add(Queen.createWhiteQueen(new Position(7, 3)));
        r.add(King.createWhiteKing(new Position(7, 4)));
        r.add(Bishop.createWhiteBishop(new Position(7, 2)));
        r.add(Knight.createWhiteKnight(new Position(7, 1)));
        r.add(Rook.createWhiteRook(new Position(7, 0)));

        return new Rank(r);
    }

    public static Rank createBlackOthers() {
        List<Piece> r = new ArrayList<>();

        r.add(Rook.createBlackRook(new Position(0, 0)));
        r.add(Knight.createBlackKnight(new Position(0, 1)));
        r.add(Bishop.createBlackBishop(new Position(0, 2)));
        r.add(Queen.createBlackQueen(new Position(0, 3)));
        r.add(King.createBlackKing(new Position(0, 4)));
        r.add(Bishop.createBlackBishop(new Position(0, 2)));
        r.add(Knight.createBlackKnight(new Position(0, 1)));
        r.add(Rook.createBlackRook(new Position(0, 0)));

        return new Rank(r);
    }

    public static Rank createBlank(int row) {
        List<Piece> r = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            r.add(Blank.createBlank(new Position(row, i)));
        }

        return new Rank(r);
    }
}
