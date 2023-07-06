package softeer2nd.chess;

import softeer2nd.utils.StringUtils;

import static softeer2nd.chess.pieces.Piece.Color.NO_COLOR;
import static softeer2nd.chess.pieces.Piece.Color.WHITE;

public class ChessView {

    public static String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            StringBuilder sb2 = new StringBuilder();
            Board.getChessBoard().get(i).getRank().forEach(p -> {
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
