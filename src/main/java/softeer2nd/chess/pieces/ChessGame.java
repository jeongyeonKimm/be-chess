package softeer2nd.chess.pieces;

import softeer2nd.chess.Board;
import softeer2nd.chess.Position;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static softeer2nd.chess.pieces.Piece.Color.BLACK;
import static softeer2nd.chess.pieces.Piece.Color.WHITE;
import static softeer2nd.chess.pieces.Piece.Type.PAWN;

public class ChessGame {
    public static int pieceCount() {
        int size = 0;
        for (int i = 0; i < Board.getChessBoard().size(); i++) {
            if (i == 0 || i == 1 || i == 6 || i == 7) {
                size += Board.getChessBoard().get(i).getRank().size();
            }
        }
        return size;
    }

    public static int pieceCountByColorAndType(Piece.Color color, Piece.Type type) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            count += (int) Board.getChessBoard().get(i).getRank()
                    .stream()
                    .filter(p -> p.getColor().equals(color) && p.getType().equals(type)).count();
        }
        return count;
    }

    public static Piece findPiece(String location) {
        Position position = new Position(location);

        return Board.getChessBoard().get(position.getY()).getRank().get(position.getX());
    }

    public static void move(String source, String target) {
        Position sourcePos = new Position(source);
        Position targetPos = new Position(target);

        Piece findPiece = findPiece(source);
        Board.getChessBoard()
                .get(targetPos.getY())
                .getRank()
                .set(targetPos.getX(), Piece.createPiece(findPiece.getColor(), findPiece.getType(), targetPos));
        Board.getChessBoard().get(sourcePos.getY()).getRank().set(sourcePos.getX(), Piece.createBlank(sourcePos));
    }

    public static double calculatePoint(Piece.Color color) {
        double totalPoint = 0;

        if (color.equals(WHITE)) {
            for (int i = 0; i < 8; i++) {
                totalPoint += getTotalPoint(i, WHITE);
            }
        } else if (color.equals(BLACK)){
            for (int i = 0; i < 8; i++) {
                totalPoint += getTotalPoint(i, BLACK);
            }
        }

        return totalPoint;
    }

    private static double getTotalPoint(int row, Piece.Color color) {
        double totalPoint = 0;
        List<Piece> pieces = Board.getChessBoard().get(row).getRank();

        for (Piece piece : pieces) {
            if (piece.getColor().equals(color)) {
                totalPoint += getPiecePoint(piece, row, pieces.indexOf(piece));
            }
        }
        return totalPoint;
    }

    private static double getPiecePoint(Piece piece, int row, int col) {
        double piecePoint = piece.getType().getDefaultPoint();

        if (piece.getType().equals(PAWN) && existPawn(piece.getColor(), row, col)) {
            piecePoint = 0.5;
        }

        return piecePoint;
    }

    private static boolean existPawn(Piece.Color color, int row, int col) {
        boolean flag = false;
        for (int i = 0; i < 8; i++) {
            Piece piece = Board.getChessBoard().get(i).getRank().get(col);
            if (piece.getType().equals(PAWN) && piece.getColor().equals(color) && i != row) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static List<Piece> sortAscByPoint(Piece.Color color) {
        List<Piece> pieceList = new ArrayList<>();
        for (Board.Rank rank : Board.getChessBoard()) {
            rank.getRank().stream().filter(p -> p.getColor().equals(color)).forEach(pieceList::add);
        }

        pieceList.sort(Comparator.comparingDouble(piece -> piece.getType().getDefaultPoint()));

        return pieceList;
    }

    public static List<Piece> sortDescByPoint(Piece.Color color) {
        List<Piece> pieceList = new ArrayList<>();
        for (Board.Rank rank : Board.getChessBoard()) {
            rank.getRank().stream().filter(p -> p.getColor().equals(color)).forEach(pieceList::add);
        }

        pieceList.sort(Comparator.comparingDouble(piece -> -piece.getType().getDefaultPoint()));

        return pieceList;
    }
}
