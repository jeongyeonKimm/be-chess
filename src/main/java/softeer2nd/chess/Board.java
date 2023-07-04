package softeer2nd.chess;

import softeer2nd.chess.pieces.Pawn;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pawn> pawns;

    public Board() {
        pawns = new ArrayList<>();
    }

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int idx) {
        return pawns.get(idx);
    }
}
