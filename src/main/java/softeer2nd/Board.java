package softeer2nd;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Pawn> pawns = new ArrayList<>();

    public Board(List<Pawn> pawns) {
        this.pawns = pawns;
    }

    public List<Pawn> getPawns() {
        return pawns;
    }
}
