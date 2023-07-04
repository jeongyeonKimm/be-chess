package softeer2nd.chess;

import softeer2nd.chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final Pawn[][] chessBoard = new Pawn[8][8];
    private List<Pawn> whitePawnsList = new ArrayList<>();
    private List<Pawn> blackPawnsList = new ArrayList<>();

    public Board() {
    }

    public String getWhitePawnsResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(whitePawnsList.get(i).getRepresentation());
        }
        return sb.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(blackPawnsList.get(i).getRepresentation());
        }
        return sb.toString();
    }

    public void add(Pawn pawn) {
        if (pawn.getColor().equals(Pawn.WHITE_COLOR)) {
            whitePawnsList.add(pawn);
        } else {
            blackPawnsList.add(pawn);
        }
    }

    public int size() {
        return whitePawnsList.size() + blackPawnsList.size();
    }

    public Pawn findPawn(int row, int col) {
        return chessBoard[row][col];
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 1) {
                    Pawn black = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
                    chessBoard[6][j] = black;
                    blackPawnsList.add(black);
                } else if (i == 6) {
                    Pawn white = new Pawn();
                    chessBoard[1][j] = white;
                    whitePawnsList.add(white);
                }
            }
        }
    }
}
