package softeer2nd.chess;

import softeer2nd.chess.pieces.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static softeer2nd.chess.Board.*;
import static softeer2nd.chess.pieces.Color.BLACK;
import static softeer2nd.chess.pieces.Color.WHITE;
import static softeer2nd.chess.pieces.Type.*;
import static softeer2nd.chess.pieces.Type.KNIGHT;
import static softeer2nd.chess.pieces.Type.ROOK;

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
            r.add(Piece.createPiece(WHITE, PAWN, new Position(i, WHITE_PAWNS_RANK_NUM)));
        }

        return new Rank(r);
    }

    public static Rank createBlackPawns() {
        List<Piece> r = new ArrayList<>();

        for (int i = 0; i < Board.BOARD_LENGTH; i++) {
            r.add(Piece.createPiece(BLACK, PAWN, new Position(i, BLACK_PAWNS_RANK_NUM)));
        }

        return new Rank(r);
    }

    public static Rank createWhiteOthers() {
        List<Piece> r = new ArrayList<>();

        r.add(Piece.createPiece(WHITE, ROOK, new Position(0, WHITE_OTHERS_RANK_NUM)));
        r.add(Piece.createPiece(WHITE, KNIGHT, new Position(1, WHITE_OTHERS_RANK_NUM)));
        r.add(Piece.createPiece(WHITE, BISHOP, new Position(2, WHITE_OTHERS_RANK_NUM)));
        r.add(Piece.createPiece(WHITE, QUEEN, new Position(3, WHITE_OTHERS_RANK_NUM)));
        r.add(Piece.createPiece(WHITE, KING, new Position(4, WHITE_OTHERS_RANK_NUM)));
        r.add(Piece.createPiece(WHITE, BISHOP, new Position(5, WHITE_OTHERS_RANK_NUM)));
        r.add(Piece.createPiece(WHITE, KNIGHT, new Position(6, WHITE_OTHERS_RANK_NUM)));
        r.add(Piece.createPiece(WHITE, ROOK, new Position(7, WHITE_OTHERS_RANK_NUM)));

        return new Rank(r);
    }

    public static Rank createBlackOthers() {
        List<Piece> r = new ArrayList<>();

        r.add(Piece.createPiece(BLACK, ROOK, new Position(0, BLACK_OTHERS_RANK_NUM)));
        r.add(Piece.createPiece(BLACK, KNIGHT, new Position(1, BLACK_OTHERS_RANK_NUM)));
        r.add(Piece.createPiece(BLACK, BISHOP, new Position(2, BLACK_OTHERS_RANK_NUM)));
        r.add(Piece.createPiece(BLACK, QUEEN, new Position(3, BLACK_OTHERS_RANK_NUM)));
        r.add(Piece.createPiece(BLACK, KING, new Position(4, BLACK_OTHERS_RANK_NUM)));
        r.add(Piece.createPiece(BLACK, BISHOP, new Position(5, BLACK_OTHERS_RANK_NUM)));
        r.add(Piece.createPiece(BLACK, KNIGHT, new Position(6, BLACK_OTHERS_RANK_NUM)));
        r.add(Piece.createPiece(BLACK, ROOK, new Position(7, BLACK_OTHERS_RANK_NUM)));

        return new Rank(r);
    }

    public static Rank createBlank(int row) {
        List<Piece> r = new ArrayList<>();

        for (int i = 0; i < Board.BOARD_LENGTH; i++) {
            r.add(Piece.createPiece(Color.NO_COLOR, NO_PIECE, new Position(i, row)));
        }

        return new Rank(r);
    }
}
