package softeer2nd.chess;

import softeer2nd.chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private ArrayList<Pawn> pawns;

    public Board() {
        pawns = new ArrayList<>();
    }

    public Board(ArrayList<Pawn> pawns) {
        this.pawns = pawns;
    }

    public List<Pawn> getPawns() {
        return pawns;
    }

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int idx) {
        if (pawns.size() == 0) {
            return null;
        }
        return pawns.get(idx);
    }
}
