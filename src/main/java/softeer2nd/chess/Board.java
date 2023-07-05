package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;
import softeer2nd.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<List<Piece>> chessBoard = new ArrayList<>();
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
        return chessBoard.get(row).get(col);
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
                chessBoard.add(new ArrayList<>());
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

    public List<Piece> createWhitePawn() {
        List<Piece> whitePawns = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Piece white = Piece.createWhitePawn();
            whitePawns.add(white);
        }
        return whitePawns;
    }

    public List<Piece> createBlackPawn() {
        List<Piece> blackPawns = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Piece black = Piece.createBlackPawn();
            blackPawns.add(black);
        }
        return blackPawns;
    }

    public List<Piece> createWhiteOthers() {
        List<Piece> whiteOthers = new ArrayList<>();
        whiteOthers.add(Piece.createWhiteRook());
        whiteOthers.add(Piece.createWhiteKnight());
        whiteOthers.add(Piece.createWhiteBishop());
        whiteOthers.add(Piece.createWhiteQueen());
        whiteOthers.add(Piece.createWhiteKing());
        whiteOthers.add(Piece.createWhiteBishop());
        whiteOthers.add(Piece.createWhiteKnight());
        whiteOthers.add(Piece.createWhiteRook());

        return whiteOthers;
    }

    public List<Piece> createBlackOthers() {
        List<Piece> blackOthers = new ArrayList<>();
        blackOthers.add(Piece.createBlackRook());
        blackOthers.add(Piece.createBlackKnight());
        blackOthers.add(Piece.createBlackBishop());
        blackOthers.add(Piece.createBlackQueen());
        blackOthers.add(Piece.createBlackKing());
        blackOthers.add(Piece.createBlackBishop());
        blackOthers.add(Piece.createBlackKnight());
        blackOthers.add(Piece.createBlackRook());

        return blackOthers;
    }

    public int pieceCount() {
        int size = 0;
        for (int i = 0; i < chessBoard.size(); i++) {
            size += chessBoard.get(i).size();
        }
        return size;
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            if (chessBoard.get(i).isEmpty()) {
                sb.append(StringUtils.appendNewLine("........"));
            } else {
                StringBuilder sb2 = new StringBuilder();
                chessBoard.get(i).forEach(p -> sb2.append(p.getRepresentation()));
                sb.append(StringUtils.appendNewLine(sb2.toString()));
            }
        }
        return sb.toString();
    }
}
