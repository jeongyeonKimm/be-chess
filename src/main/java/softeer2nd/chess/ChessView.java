package softeer2nd.chess;

import softeer2nd.utils.StringUtils;

import static softeer2nd.chess.pieces.Color.NO_COLOR;
import static softeer2nd.chess.pieces.Color.WHITE;

public class ChessView {

    private final Board board;

    public ChessView(Board board) {
        this.board = board;
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Board.BOARD_LENGTH; i++) {
            showRank(sb, i);
        }

        return sb.toString();
    }

    private void showRank(StringBuilder sb, int i) {
        StringBuilder sb2 = new StringBuilder();
        board.getChessBoard().get(i).getRank().forEach(p -> {
            if (p.isColor(WHITE) || p.isColor(NO_COLOR)) {
                sb2.append(p.getType().getRepresentation());
            } else {
                sb2.append(Character.toUpperCase(p.getType().getRepresentation()));
            }
        });
        sb.append(StringUtils.appendNewLine(sb2.toString()));
    }
}
