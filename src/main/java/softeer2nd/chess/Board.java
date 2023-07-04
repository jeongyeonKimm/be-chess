package softeer2nd.chess;

import softeer2nd.chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private ArrayList<Pawn> chessBoard = new ArrayList<>();
    private List<Pawn> whitePawnsList = new ArrayList<>();
    private List<Pawn> blackPawnsList = new ArrayList<>();

    public Board() {
    }

    public void add(Pawn pawn) {
        chessBoard.add(pawn);
    }

    public int size() {
        return chessBoard.size();
    }

    public Pawn findPawn(int idx) {
        return chessBoard.get(idx);
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

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 1) {
                    blackPawnsList.add(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
                } else if (i == 6) {
                    whitePawnsList.add(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
                }
            }
        }
    }
}
