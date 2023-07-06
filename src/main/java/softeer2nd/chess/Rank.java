package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

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
}
