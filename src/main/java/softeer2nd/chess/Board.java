package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;
import softeer2nd.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final Piece[][] chessBoard = new Piece[8][8];
    private List<Piece> whitePawnsList = new ArrayList<>();
    private List<Piece> blackPawnsList = new ArrayList<>();

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

    public void add(Piece pawn) {
        if (pawn.getColor().equals(Piece.WHITE_COLOR)) {
            whitePawnsList.add(pawn);
        } else {
            blackPawnsList.add(pawn);
        }
    }

    public int size() {
        return whitePawnsList.size() + blackPawnsList.size();
    }

    public Piece findPawn(int row, int col) {
        return chessBoard[row][col];
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            if (i == 1) {
                createBlackPawn();
            } else if (i == 6) {
                createWhitePawn();
            }
        }
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            if (i == 1) {
                sb.append(getBlackPawnsResult());
                sb = new StringBuilder(StringUtils.appendNewLine(sb.toString()));
            } else if (i == 6) {
                sb.append(getWhitePawnsResult());
                sb = new StringBuilder(StringUtils.appendNewLine(sb.toString()));
            } else {
                sb.append("........");
                sb = new StringBuilder(StringUtils.appendNewLine(sb.toString()));
            }
        }

        return sb.toString();
    }

    public void createBlackPawn() {
        for (int i = 0; i < 8; i++) {
            Piece black = Piece.createBlackPawn();
            chessBoard[6][i] = black;
            blackPawnsList.add(black);
        }
    }

    public void createWhitePawn() {
        for (int i = 0; i < 8; i++) {
            Piece white = Piece.createWhitePawn();
            chessBoard[1][i] = white;
            whitePawnsList.add(white);
        }
    }
}
