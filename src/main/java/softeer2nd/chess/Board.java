package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Piece.Type;
import softeer2nd.utils.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static softeer2nd.chess.pieces.Piece.Color.*;
import static softeer2nd.chess.pieces.Piece.Type.*;

public class Board {

    public static class Rank {
        private final List<Piece> rank = new ArrayList<>();
    }

    private final List<Rank> chessBoard = new ArrayList<>();
    private Type[] typeOrder = new Type[] {ROOK, KNIGHT, BISHOP, QUEEN, KING, BISHOP, KNIGHT, ROOK};

    public Board() {
    }

    public List<Rank> getChessBoard() {
        return chessBoard;
    }

    public Piece findPawn(int row, int col) {
        return chessBoard.get(row).rank.get(col);
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
}
