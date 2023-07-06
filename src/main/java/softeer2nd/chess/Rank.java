package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Rank {
    private List<Piece> rank = new ArrayList<>();

    public List<Piece> getRank() {
        return rank;
    }
}
